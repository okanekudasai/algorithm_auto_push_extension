// 문제 : 주사위
// 결과 :  / 속도: 120 / 메모리 : 14336
// 제출시각 : 24-02-29  3:53:22
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
​
        long N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long [] data = new long [7];
        for (int i = 1; i <= 6; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
​
        if (N == 1) {
            int sum = 0;
            int max_num = -1;
            for (int i = 1; i <= 6; i++) {
                sum += data[i];
                max_num = Math.max(max_num, (int) data[i]);
            }
            System.out.println(sum - max_num);
            return;
        }
​
        long min1 = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            min1 = Math.min(min1, data[i]);
        }
​
        long min2 = Integer.MAX_VALUE;
        min2 = Math.min(min2, data[3] + data[1]);
        min2 = Math.min(min2, data[3] + data[2]);
        min2 = Math.min(min2, data[3] + data[5]);
        min2 = Math.min(min2, data[3] + data[6]);
        min2 = Math.min(min2, data[4] + data[1]);
        min2 = Math.min(min2, data[4] + data[2]);
        min2 = Math.min(min2, data[4] + data[5]);
        min2 = Math.min(min2, data[4] + data[6]);
        min2 = Math.min(min2, data[1] + data[2]);
        min2 = Math.min(min2, data[2] + data[6]);
        min2 = Math.min(min2, data[6] + data[5]);
        min2 = Math.min(min2, data[5] + data[1]);
​
        long min3 = Integer.MAX_VALUE;
        min3 = Math.min(min3, data[1] + data[4] + data[5]);
        min3 = Math.min(min3, data[1] + data[2] + data[4]);
        min3 = Math.min(min3, data[1] + data[2] + data[3]);
        min3 = Math.min(min3, data[1] + data[3] + data[5]);
        min3 = Math.min(min3, data[6] + data[2] + data[4]);
        min3 = Math.min(min3, data[6] + data[2] + data[3]);
        min3 = Math.min(min3, data[6] + data[4] + data[5]);
        min3 = Math.min(min3, data[6] + data[3] + data[5]);
​
//        System.out.println(min1+ " " + min2 + " " + min3);
        long answer = 0;
        answer += min1 * ((N-2) * (N-2) * 5);
        answer += min1 * ((N-2) * 4);
        answer += min2 * ((N-2) * 8);
        answer += min2 * 4;
        answer += min3 * 4;
​
        System.out.println(answer);
    }
}
