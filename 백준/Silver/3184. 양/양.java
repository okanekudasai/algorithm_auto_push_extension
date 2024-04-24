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

        char [] [] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int o_answer = 0;
        int v_answer = 0;

        boolean [] [] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                if (board[i][j] == '#') continue;
                visit[i][j] = true;
                ArrayDeque<Node> q = new ArrayDeque<>();
                q.offerLast(new Node(i, j));
                int o_count = 0;
                int v_count = 0;
                if (board[i][j] == 'o') o_count++;
                else if (board[i][j] == 'v') v_count++;
                while(!q.isEmpty()) {
                    Node present = q.pollFirst();
                    for (int [] d : delta) {
                        Node next = new Node(present.r + d[0], present.c + d[1]);
                        if (next.r < 0 || next.r >= N || next.c < 0 || next.c >= M) continue;
                        if (visit[next.r][next.c]) continue;
                        if (board[next.r][next.c] == '#') continue;
                        visit[next.r][next.c] = true;
                        if (board[next.r][next.c] == 'o') o_count++;
                        else if (board[next.r][next.c] == 'v') v_count++;
                        q.offerLast(next);
                    }
                }
                if (o_count > v_count) o_answer += o_count;
                else v_answer += v_count;
            }
        }
        System.out.println(o_answer + " " + v_answer);
    }
}