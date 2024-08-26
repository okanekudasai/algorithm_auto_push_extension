import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] [] board = new int [N+1] [M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [] [] sumBoard = new int [N+1] [M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sumBoard[i][j] = board[i][j] + sumBoard[i-1][j] + sumBoard[i][j-1] - sumBoard[i-1][j-1];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int r1 = 1; r1 <= N; r1++) {
            for (int c1 = 1; c1 <= M; c1++) {
                for (int r2 = r1; r2 <= N; r2++) {
                    for (int c2 = c1; c2 <= M ; c2++) {
                        int sum = sumBoard[r2][c2] - sumBoard[r1-1][c2] - sumBoard[r2][c1-1] + sumBoard[r1-1][c1-1];
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
