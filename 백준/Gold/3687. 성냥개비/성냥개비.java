import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
//
        for (int testcase = 1; testcase <= T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(getMin(N)).append(' ').append(getMax(N)).append('\n');
        }
        System.out.println(sb);
    }

    private static String getMax(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n/2; i++) {
                sb.append(1);
            }
        } else {
            sb.append(7);
            for (int i = 0; i < (n-3) / 2; i++) {
                sb.append(1);
            }
        }
        return sb.toString();
    }

    private static String getMin(int N) {
        int [] answer = {0, 0, 1, 7, 4, 2, 6, 8, 10, 18, 22, 20, 28, 68, 88, 108, 188, 200, 208, 288, 688, 888};
        if (N > 21) {
            StringBuilder sb = new StringBuilder();
            sb.append(answer[N - 7 * ((N / 7) - 2)]);
            for (int i = 0; i < (N - 21) / 7 + 1; i++) sb.append(8);
            return sb.toString();
        } else {
            return String.valueOf(answer[N]);
        }
    }
}
//22 -> 15
//29 -> 15