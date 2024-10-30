import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testcase = 1; testcase <= T; testcase++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb.append(solution(st.nextToken().toCharArray(), st.nextToken().toCharArray())).append('\n');
        }
        System.out.print(sb);
    }
    static int solution(char [] a, char [] b) {
        int N = a.length;
        int oneZero = 0;
        int zeroOne = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] == b[i]) continue;
            if (a[i] == '0' && b[i] == '1') zeroOne++;
            if (a[i] == '1' && b[i] == '0') oneZero++;
        }
        return Math.max(zeroOne, oneZero);
    }
}