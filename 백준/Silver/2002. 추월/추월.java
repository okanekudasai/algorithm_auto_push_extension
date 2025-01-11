import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String [] arg) throws IOException {
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) map.put(br.readLine(), i);
        int [] data = new int [N];
        for (int i = 0; i < N; i++) data[i] = map.get(br.readLine());
//        System.out.println(Arrays.toString(data));
        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
//                System.out.println(data[i] + " " + data[j]);
                if (data[i] > data[j]) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
