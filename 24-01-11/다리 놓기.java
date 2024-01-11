// 문제 : 다리 놓기
// 결과 :  / 속도: 156 / 메모리 : 14396
// 제출시각 : 24-01-11  20:33:48
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= tc; testcase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n > m/2) n = m-n;
            long answer = 1;
            for (int i = m-n+1; i <= m; i++) {answer *= i;}
            for (int i = 2; i <= n; i++) {answer /= i;}
            System.out.println(answer);
        }
    }
}
