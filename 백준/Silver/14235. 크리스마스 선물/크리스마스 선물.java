import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                if (heap.isEmpty()) sb.append(-1);
                else sb.append(heap.poll());
                sb.append('\n');
            } else {
                for (int k = 0; k < a; k++) {
                    heap.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}