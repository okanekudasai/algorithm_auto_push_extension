// 문제 : 크냐?
// 결과 :  / 속도: 128 / 메모리 : 14188
// 제출시각 : 24-01-28  7:4:28
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
​
public class Main {
    public static void main(String[] args) throws IOException {
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
​
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            System.out.println((N > M) ? "Yes" : "No");
        }
    }
}
