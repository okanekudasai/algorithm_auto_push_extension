import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Long::compareTo);
        for (int i = 0; i < 10; i++) {
            ArrayDeque<Integer> ad = new ArrayDeque<>();
            ad.offerFirst(i);
            rec(ad, pq);
        }
        if (N >= pq.size()) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < N; i++) {
            pq.poll();
        }
        System.out.println(pq.peek());
    }
    static void rec(ArrayDeque<Integer> stack, PriorityQueue<Long> pq) {
        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append(i);
        pq.offer(Long.parseLong(sb.toString()));
        int head = stack.peekFirst();
        for (int i = head + 1; i < 10; i++) {
            stack.offerFirst(i);
            rec(stack, pq);
            stack.pollFirst();
        }
    }
}