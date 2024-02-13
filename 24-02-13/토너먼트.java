// 문제 : 토너먼트
// 결과 :  / 속도: 124 / 메모리 : 14196
// 제출시각 : 24-02-13  14:29:48
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (A > B) {
            int temp = B;
            B = A;
            A = temp;
        }
        int answer = 2;
        int helper = 1;
        while (true) {
            helper *= 2;
            if (helper >= N) break;
            answer++;
        }
        int left = 0;
        int right = helper;
        while (true) {
            answer--;
            int mid = (left + right) / 2;
            if (A <= mid && mid < B) break;
            else if (B <= mid) right = mid;
            else left = mid;
        }
        System.out.println(answer);
    }
}
