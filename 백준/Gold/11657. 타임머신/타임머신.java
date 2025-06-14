import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

class Vertex {
    int destination, cost;
    Vertex(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}

public class Main {
    static private final int BUF_SIZE = 1 << 13;
    static private final byte [] buf = new byte [BUF_SIZE];
    static private int cursor = -1;
    static private int cursor_max = 0;
    static byte read() throws IOException {
        if (++cursor == cursor_max) {
            cursor_max = System.in.read(buf, 0, BUF_SIZE);
            cursor = 0;
        }
        return buf[cursor];
    }
    static int readInt() throws IOException {
        int res = 0;
        boolean negative = false;
        while (true) {
            byte in = read();
            if (in <= 32) return res;
            if ((char) in == '-') {
                negative = true;
                continue;
            }
            if (negative) res = (res << 3) + (res << 1) - (in & 15);
            else res = (res << 3) + (res << 1) + (in & 15);
        }
    }
    static public void main(String [] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int [] [] graph = new int [N + 1] [N + 1];
        boolean [] [] noway = new boolean [N + 1] [N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.MAX_VALUE;
                noway[i][j] = true;
            }
        }
        for (int i = 0; i < M; i++) {
            int A = readInt();
            int B = readInt();
            int cost = readInt();
            graph[A][B] = Math.min(graph[A][B], cost);
            noway[A][B] = false;
        }
        System.out.print(solution(N, graph, noway));
    }
    static String solution(int N, int [] [] graph, boolean [] [] noway) {
        long [] costFromOne = new long [N + 1];
        Arrays.fill(costFromOne, Long.MAX_VALUE);
        boolean [] inf = new boolean [N + 1];
        Arrays.fill(inf, true);
        costFromOne[1] = 0;
        inf[1] = false;
        for (int cycle = 0; cycle < N - 1; cycle++) {
            for (int start = 1; start <= N; start++) {
                if (inf[start]) continue;
                for (int end = 1; end <= N; end++) {
                    if (start == end) continue;
                    if (noway[start][end]) continue;
                    costFromOne[end] = Math.min(costFromOne[end], costFromOne[start] + graph[start][end]);
                    inf[end] = false;
                }
            }
        }
        for (int start = 1; start <= N; start++) {
            if (inf[start]) continue;
            for (int end = 1; end <= N; end++) {
                if (noway[start][end]) continue;
                if (costFromOne[end] > costFromOne[start] + graph[start][end]) {
                    return "-1";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (inf[i]) sb.append(-1);
            else sb.append(costFromOne[i]);
            sb.append('\n');
        }
        return sb.toString();
    }
}