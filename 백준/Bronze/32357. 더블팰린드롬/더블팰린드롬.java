import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Loop1:
        for (int i = 0; i < N; i++) {
            char [] S = br.readLine().toCharArray();
            int l = S.length;
            for (int a = l / 2 - 1, b = l / 2; a >= 0; a--, b++) {
                if (S[a] != S[b]) continue Loop1;
            }
            count++;
        }
        System.out.println(count * (count - 1));
    }
}