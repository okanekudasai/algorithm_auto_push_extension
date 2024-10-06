import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> nonBOJ = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        PriorityQueue<Integer> BOJ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.startsWith("boj.kr/")) {
                int t = Integer.parseInt(s.split("/")[1]);
                BOJ.offer(t);
            } else {
                nonBOJ.offer(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!nonBOJ.isEmpty()) {
            sb.append(nonBOJ.poll()).append('\n');
        }
        while(!BOJ.isEmpty()) {
            sb.append("boj.kr/").append(BOJ.poll()).append('\n');
        }
        System.out.print(sb);
    }
}
