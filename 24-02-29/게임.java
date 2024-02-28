// 문제 : 게임
// 결과 :  / 속도: 140 / 메모리 : 15580
// 제출시각 : 24-02-29  4:30:53
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    static int [] [] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean infinity = false;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
​
        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int [] [] board = new int [R] [C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char temp = s.charAt(j);
                if (temp == 'H') board[i][j] = -1;
                else board[i][j] = temp - '0';
            }
        }
//        for (int [] i : board) System.out.println(Arrays.toString(i));
        boolean [] [] pass = new boolean [R] [C];
        int [] [] max_count = new int [R] [C];
​
        max_count[0][0] = 1;
        pass[0][0] = true;
        dfsing(0, 0, 1, R, C, pass, max_count, board);
​
        System.out.println(infinity ? -1 : answer);
    }
    static void dfsing(int r, int c, int level, int R, int C, boolean [] [] pass, int [] [] max_count, int [] [] board) {
        answer = Math.max(answer, level);
        for (int [] d : delta) {
            int next_r = r + d[0] * board[r][c];
            int next_c = c + d[1] * board[r][c];
            if (next_r < 0 || next_r >= R || next_c < 0 || next_c >= C) continue;
            if (board[next_r][next_c] == -1) continue;
            if (max_count[next_r][next_c] >= level) continue;
            if (pass[next_r][next_c]) {
                infinity = true;
                return;
            }
            max_count[next_r][next_c] = level;
            pass[next_r][next_c] = true;
            if(!infinity) dfsing(next_r, next_c, level+1, R, C, pass, max_count, board);
            pass[next_r][next_c] = false;
        }
    }
}
