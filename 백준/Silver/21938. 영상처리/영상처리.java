import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
    int r, c;
    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Main {
    static int [] [] delta = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] [] board = new int [N] [M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                board[i][j] = (R+G+B) / 3;
            }
        }

        int T = Integer.parseInt(br.readLine());

        int answer = 0;
        boolean [] [] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] < T) continue;
                if (visit[i][j]) continue;
                answer++;
                ArrayDeque<Node> q = new ArrayDeque<>();
                visit[i][j] = true;
                q.offerLast(new Node(i, j));
                while (!q.isEmpty()) {
                    Node p = q.pollFirst();
                    for (int [] d : delta) {
                        Node next = new Node(p.r + d[0], p.c + d[1]);
                        if (next.r < 0 || next.r >= N || next.c < 0 || next.c >= M) continue;
                        if (board[next.r][next.c] < T) continue;
                        if (visit[next.r][next.c]) continue;
                        visit[next.r][next.c] = true;
                        q.offerLast(next);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}