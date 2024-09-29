import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testcase = 1; testcase <= T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int [] coin = new int [N+1];
            for (int i = 1; i <= N; i++) coin[i] = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(br.readLine());
            sb.append(solution(N, coin, target)).append('\n');
        }
        System.out.print(sb);
    }
    static int solution(int N, int [] coin, int target) {
        int [] [] dp = new int [N+1] [target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j] + ((j - coin[i] < 0) ? 0 : dp[i][j - coin[i]]);
            }
        }
        return dp[N][target];
    }
}