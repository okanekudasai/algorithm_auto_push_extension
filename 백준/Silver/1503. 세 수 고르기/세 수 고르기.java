
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        Set<Integer> targetNumber = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreElements()) targetNumber.add(Integer.parseInt(st.nextToken()));
        solution(targetNumber, N);
    }
    static void solution(Set<Integer> targetNumber, int N) {
        int answer = 1000000000;
        for (int x = 1; x <= 1001; x++) {
            if (targetNumber.contains(x)) continue;
            for (int y = x; y <= 1001; y++) {
                if (targetNumber.contains(y)) continue;
                for (int z = y; z <= 1001; z++) {
                    if (targetNumber.contains(z)) continue;
                    answer = Math.min(answer, Math.abs(N - x * y * z));
//                    System.out.println(x + " " + y + " "+ z + " *** " + Math.abs(N - x * y * z) + " " + answer);
                    if (N < x * y * z) break;
                }
                if (N < x * y) break;
            }
        }
        System.out.println(answer);
    }
}