import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] [] delta = {{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean [] [] board = new boolean[N][M];
        for (int i = N-1; i >= 0; i--) {
            char [] s = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (s[j] == '.') board[i][j] = true;
            }
        }

//        for (boolean [] b : board) System.out.println(Arrays.toString(b));

        boolean [] [] visit = new boolean [N] [M];
        visit[0][0] = true;
        int answer = dfsing(0, 0, N, M, K, 1, board, visit);
        System.out.println(answer);
    }
    static int dfsing(int r, int c, int N, int M, int K, int count, boolean [] [] board, boolean [] [] visit) {
//        System.out.println(r + " " + c);
        if (count >= K) {
//            System.out.println("*");
            if (r == N-1 && c == M-1) return 1;
            else return 0;
        }
        int sub = 0;
        for (int [] d : delta) {
            int next_r = r + d[0];
            int next_c = c + d[1];
            if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= M) continue;
            if (visit[next_r][next_c]) continue;
            if (!board[next_r][next_c]) continue;

            visit[next_r][next_c] = true;
            sub += dfsing(next_r, next_c, N, M, K, count+1, board, visit);
            visit[next_r][next_c] = false;
        }

        return sub;
    }

}
