// 문제 : 책 페이지
// 결과 :  / 속도: 144 / 메모리 : 15848
// 제출시각 : 24-01-11  20:40:38
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
​
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int moto = N;
        int [] answer = new int [10];
        int level = 1;
        while (N > 0) {
            int d = N % 10;
            N /= 10;
            int [] temp = new int [10];
            for (int i = 0; i < 10; i++) {
                temp[i] = N;
                if (i > 0 && i <= d) temp[i]++;
                temp[i] *= level;
                if (i == d) temp[i] -= level - moto%level - 1;
            }
            level *= 10;
//            System.out.println(Arrays.toString(temp));
            for (int i = 0; i < 10; i++) {
                answer[i] += temp[i];
            }
        }
//        System.out.println(Arrays.toString(answer));
​
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
