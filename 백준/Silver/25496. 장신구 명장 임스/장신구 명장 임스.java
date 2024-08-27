import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        while (!q.isEmpty()) {
            if (P >= 200) break;
            P += q.poll();
            answer++;
        }
        System.out.println(answer);
    }
}