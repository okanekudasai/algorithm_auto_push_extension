import java.io.*;
import java.util.*;

public class Main {
    static private final int BUF_SIZE = 1 << 13;
    static private final byte [] buf = new byte[BUF_SIZE];
    static private int cursor = -1;
    static private int cursorMax = 0;

    static private final int INF = 100_000_000;

    static byte read() throws IOException {
        if (++cursor == cursorMax) {
            cursorMax = System.in.read(buf, 0, BUF_SIZE);
            cursor = 0;
        }
        return buf[cursor];
    }
    static int readInt() throws IOException {
        int res = 0;
        while (true) {
            byte in = read();
            if (in <= 32) return res;
            res = (res << 3) + (res << 1) + (in & 15);
        }
    }
    static public void main(String [] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int [] [] edge = new int [N+1] [N+1];
        for (int [] i : edge) Arrays.fill(i, INF);
        for (int i = 1; i <= N; i++) edge[i][i] = 0;
        for (int i = 0; i < M; i++) {
            int a = readInt();
            int b = readInt();
            int cost = readInt();
            edge[a][b] = cost;
        }
        System.out.println(solution(N, edge));
    }
    static int solution(int N, int [] [] edge) {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    edge[i][j] = Math.min(edge[i][j], edge[i][k] + edge[k][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (edge[i][j] == INF || edge[j][i] == INF) continue;
                answer = Math.min(answer, edge[i][j] + edge[j][i]);
            }
        }
        if (answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
}