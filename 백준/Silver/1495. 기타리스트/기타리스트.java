import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int [] data = new int [N];
        for (int i = 0; i < N; i++) data[i] = Integer.parseInt(st.nextToken());
        boolean [] [] board = new boolean [N+1] [M+1];
        board[0][S] = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (!board[i][j]) continue;
                if (j - data[i] >= 0) board[i+1][j-data[i]] = true;
                if (j + data[i] <= M) board[i+1][j+data[i]] = true;
            }
        }
        for (int i = M; i >= 0; i--) {
            if (board[N][i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}