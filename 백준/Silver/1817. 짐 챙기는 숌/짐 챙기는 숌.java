import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int [] data = new int [N];

        for (int i = 0; i < N; i++) data[i] = Integer.parseInt(st.nextToken());

        int answer = 1;
        int p = data[0];
        for (int i = 1; i < N; i++) {
            if (p + data[i] > limit) {
                answer++;
                p = data[i];
                continue;
            }
            p += data[i];
        }
        System.out.println(answer);
    }
}