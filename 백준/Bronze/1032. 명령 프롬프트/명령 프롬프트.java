import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char [] [] data = new char[N][];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().toCharArray();
        }
        char [] answer = data[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == '?') continue;
                if (answer[j] != data[i][j]) answer[j] = '?';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : answer) sb.append(c);
        System.out.println(sb);
    }
}