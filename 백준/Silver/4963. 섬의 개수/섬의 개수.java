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
class Main {
    static int [] [] delta = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) {
                break;
            }
            int [] [] board = new int [r] [c];
            for (int i = 0; i < r; i++) {
                StringTokenizer data = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < c; j++) {
                    board[i][j] = Integer.parseInt(data.nextToken());
                }
            }
            boolean [] [] visit = new boolean [r] [c];
            int answer = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] == 0) continue;
                    if (visit[i][j]) continue;
                    ArrayDeque<Node> q = new ArrayDeque<>();
                    visit[i][j] = true;
                    q.offerLast(new Node(i, j));
                    while (!q.isEmpty()) {
                        Node p = q.pollFirst();
                        for (int [] d : delta) {
                            Node next = new Node(p.r + d[0], p.c + d[1]);
                            if (next.r < 0 || next.r >= r || next.c < 0 || next.c >= c) continue;
                            if (board[next.r][next.c] == 0) continue;
                            if (visit[next.r][next.c]) continue;
                            visit[next.r][next.c] = true;
                            q.offerLast(next);
                        }
                    }
                    answer++;
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
