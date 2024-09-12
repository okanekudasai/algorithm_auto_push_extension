import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Line {
    int start, end;
    Line(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.start - o2.start;
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.offer(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Line front = null;
        int answer = 0;
        while (!pq.isEmpty()) {
            Line line = pq.poll();
            if (front == null) {
                front = line;
                continue;
            }
            if (front.end < line.start) {
                answer += front.end - front.start;
                front = line;
                continue;
            }
            front.end = Math.max(front.end, line.end);
        }
        answer += front.end - front.start;
        System.out.println(answer);
    }
}