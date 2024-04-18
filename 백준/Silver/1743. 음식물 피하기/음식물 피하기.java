import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
    int r, c;
    Node (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {

    static int [] [] delta = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean [] [] board = new boolean [N] [M];
        boolean [] [] visit = new boolean [N] [M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            board[a][b] = true;
        }

        int answer = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!board[i][j]) continue;
                if (visit[i][j]) continue;

                ArrayDeque<Node> q = new ArrayDeque<>();

                visit[i][j] = true;
                q.offerLast(new Node(i, j));

                int count = 1;

                while (!q.isEmpty()) {
                    Node present = q.pollFirst();
                    for (int [] d : delta) {
                        int next_r = present.r + d[0];
                        int next_c = present.c + d[1];
                        if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= M) continue;
                        if (!board[next_r][next_c]) continue;
                        if (visit[next_r][next_c]) continue;
                        visit[next_r][next_c] = true;
                        q.offerLast(new Node(next_r, next_c));
                        count++;
                    }
                }

                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }
}
