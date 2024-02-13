// 문제 : 마법사 상어와 토네이도
// 결과 :  / 속도: 640 / 메모리 : 40956
// 제출시각 : 24-02-13  18:17:12
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
        int N = Integer.parseInt(br.readLine());
        int [] [] board = new int [N] [N];
        int [] [] [] ratio = new int [4] [5] [5];
        answer = 0;
        ratio[0][0][2] = 2;
        ratio[0][1][1] = 10;
        ratio[0][1][2] = 7;
        ratio[0][1][3] = 1;
        ratio[0][2][0] = 5;
        ratio[0][3][1] = 10;
        ratio[0][3][2] = 7;
        ratio[0][3][3] = 1;
        ratio[0][4][2] = 2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
​
        int [] [] delta = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        for (int c1 = 4, r = 0; c1 >= 0; c1--, r++) {
            for (int r1 = 4, r2 = 0, c = 0; r1 >= 0; r1--, r2++, c++) {
                ratio[1][r1][c1] = ratio[0][r][c];
                ratio[2][r][4-c] = ratio[0][r][c];
                ratio[3][r2][c1] = ratio[0][r][c];
            }
        }
​
        int r = N / 2;
        int c = N / 2;
        int k = 2;
        int d = 0;
        Loop1:
        while (true) {
            for (int i = 0; i < k / 2; i++) {
                if (r == 0 && c == 0) break Loop1;
                making(r, c, d, N, delta, board, ratio);
                r += delta[d][0];
                c += delta[d][1];
​
//                for (int [] b : board) System.out.println(Arrays.toString(b));
//                System.out.println(answer);
//                System.out.println();
            }
            d++;
            d %= 4;
            k++;
        }
        System.out.println(answer);
    }
    static void making(int r, int c, int d, int N, int [] [] delta, int [] [] board, int [] [] [] ratio) {
        int to_zero = board[r+delta[d][0]][c+delta[d][1]];
        int remain = to_zero;
        board[r+delta[d][0]][c+delta[d][1]] = 0;
        for (int i = r+delta[d][0]-2, ii = 0; i <= r+delta[d][0]+2; i++, ii++) {
            for (int j = c+delta[d][1]-2, jj = 0; j <= c+delta[d][1]+2; j++, jj++) {
                int amount = (to_zero * ratio[d][ii][jj]) / 100;
                remain -= amount;
                if (i < 0 || i >= N || j < 0 || j >= N) answer += amount;
                else board[i][j] += amount;
            }
        }
        if (r+delta[d][0]*2 < 0 || r+delta[d][0]*2 >= N || c+delta[d][1]*2 < 0 || c+delta[d][1]*2 >= N) answer += remain;
        else board[r+delta[d][0]*2][c+delta[d][1]*2] += remain;
    }
}
