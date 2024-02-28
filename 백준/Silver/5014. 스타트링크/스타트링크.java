import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int [] move = new int [2];
        move[0] = Integer.parseInt(st.nextToken());
        move[1] = -Integer.parseInt(st.nextToken());

        if (S == G) {
            System.out.println(0);
            return;
        }

        int [] building = new int [F+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        building[S] = 1;
        q.offerLast(S);
        while (!q.isEmpty()) {
            int p = q.pollFirst();
            for (int i = 0; i < 2; i++) {
                int next_store = p + move[i];
                if (next_store <= 0) continue;
                if (next_store > F) continue;
                if (building[next_store] > 0) continue;
                if (next_store == G) {
                    System.out.println(building[p]);
                    return;
                }
                building[next_store] = building[p] + 1;
                q.offerLast(next_store);
            }
        }
        System.out.println("use the stairs");
    }
}