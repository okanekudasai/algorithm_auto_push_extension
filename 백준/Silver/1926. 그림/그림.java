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
        boolean [] [] board = new boolean [N] [M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) board[i][j] = true;
            }
        }
        boolean [] [] visit = new boolean [N] [M];

        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!board[i][j]) continue;
                if (visit[i][j]) continue;
                answer1++;
                ArrayDeque<Node> q = new ArrayDeque<>();

                visit[i][j] = true;
                q.offerLast(new Node(i, j));
                int count = 1;
                while (!q.isEmpty()) {
                    Node present = q.pollFirst();
                    for (int [] d : delta) {
                        int next_r = present.r + d[0];
                        int next_c = present.c + d[1];
                        Node next = new Node(next_r, next_c);
                        if (next.r < 0 || next.r >= N || next.c < 0 || next.c >= M) continue;
                        if (!board[next.r][next.c]) continue;
                        if (visit[next.r][next.c]) continue;
                        visit[next.r][next.c] = true;
                        q.offerLast(next);
                        count++;
                    }
                }
                answer2 = Math.max(answer2, count);
            }
        }
        System.out.println(answer1 + "\n" + answer2);
    }
}