import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean [] [] [] road = new boolean [N+2] [M+2] [2];

        long [] [] answer = new long [N+2] [M+2];
        answer[1][1] = 1L;

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken()) + 1;
            int a = Integer.parseInt(st.nextToken()) + 1;
            int d = Integer.parseInt(st.nextToken()) + 1;
            int c = Integer.parseInt(st.nextToken()) + 1;

            if (a + b > c + d) {
                int temp = a;
                a = c;
                c = temp;
                temp = d;
                d = b;
                b = temp;
            }

            if (a == c) {
                road[a][b][0] = true;
            } else {
                road[a][b][1] = true;
            }
        }
        for (int i = 1; i <= N+1; i++) {
            for (int j = 1; j <= M+1; j++) {
                answer[i][j] = answer[i][j] + ((road[i][j-1][0]) ? 0 : answer[i][j-1]) + ((road[i-1][j][1]) ? 0 : answer[i-1][j]);
            }
        }

//        for (int i = 1; i <= N+1; i++) {
//            for (int j = 1; j <= M+1; j++) {
//                System.out.print("[" + road[i][j][0] + ", " + road[i][j][1] + "]");
//            }
//            System.out.println();
//        }

//        for (long [] a : answer) System.out.println(Arrays.toString(a));
        System.out.println(answer[N+1][M+1]);
    }
}