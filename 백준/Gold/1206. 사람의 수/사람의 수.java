import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] data = new int [N];
        int answer = 1;
        for (int i = 0; i < N; i++) {
            char [] S = br.readLine().toCharArray();
            int number = ((S[0] - '0') * 1000) + ((S[2] - '0') * 100) + ((S[3] - '0') * 10) + (S[4] - '0');
            if (S.length == 6) number = 10000;
            data[i] = number;
        }
        System.out.println(solution(data));
    }
    static int solution(int [] data) {
        Loop:
        for (int i = 1; i <= 1000; i++) {
            for (int d : data) {
                for (int j = 0; j <= 10000; j++) {
                    int t = j * 1000 / i;
                    if (t > d) continue Loop;
                    if (t == d) break;
                }
            }
            return i;
        }
        return 10;
    }
}