import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int r, c;
    Node (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
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
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            for (int x = a; x <= c; x++) {
                for (int y = b; y <= d; y++) {
                    board[x][y] = true;
                }
            }
        }

        ArrayList<Integer> s_list = new ArrayList<>();
        boolean [] [] visit = new boolean [N] [M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j]) continue;
                if (visit[i][j]) continue;

                ArrayDeque<Node> q = new ArrayDeque<>();

                visit[i][j] = true;
                q.offerLast(new Node(i,j));
                int count = 1;

                while(!q.isEmpty()) {
                    Node present = q.pollFirst();
                    for (int [] d : delta) {
                        int next_r = present.r + d[0];
                        int next_c = present.c + d[1];
                        Node next = new Node(next_r, next_c);
                        if (next.r < 0 || next.r >= N || next.c < 0 || next.c >= M) continue;
                        if (board[next.r][next.c]) continue;
                        if (visit[next.r][next.c]) continue;
                        visit[next.r][next.c] = true;
                        q.offerLast(next);
                        count++;
                    }
                }
                s_list.add(count);
            }
        }
        s_list.sort((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        sb.append(s_list.size()).append("\n");
        for (int i : s_list) sb.append(i).append(" ");
        System.out.println(sb);
    }
}
