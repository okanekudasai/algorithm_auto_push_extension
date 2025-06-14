import java.io.*;
import java.util.*;

class Node {
    int r, c, step;
    Node (int r, int c, int step) {
        this.r = r;
        this.c = c;
        this.step = step;
    }
}

public class Main {
    static private final int BUF_SIZE = 1 << 13;
    static private final byte [] buf = new byte [BUF_SIZE];
    static private int cursor = -1;
    static private int cursor_max = 0;

    static int [] [] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static byte read() throws IOException {
        if (++cursor == cursor_max) {
            cursor_max = System.in.read(buf, 0, BUF_SIZE);
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
    static char readChar() throws IOException {
        byte in = read();
        return (char) in;
    }
    static public void main(String [] args) throws IOException {
        int N = readInt();
        int M = readInt();
        char [] [] board = new char [N] [M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = readChar();
            }
            read();
        }
        System.out.println(solution(N, M, board));
    }
    static int solution(int N, int M, char [] [] board) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'W') continue;
                boolean [] [] visit = new boolean [N] [M];
                Deque<Node> q = new ArrayDeque<>();
                q.offerLast(new Node(i, j, 0));
                visit[i][j] = true;
                int maxStep = doBfs(N, M, board, q, visit);
                answer = Math.max(answer, maxStep);
            }
        }
        return answer;
    }
    static int doBfs(int N, int M, char [] [] board, Deque<Node> q, boolean [] [] visit) {
        int maxStep = 0;
        while (!q.isEmpty()) {
            Node currentNode = q.pollFirst();
            for (int [] d : delta) {
                Node nextNode = new Node(currentNode.r + d[0], currentNode.c + d[1], currentNode.step + 1);
                if (nextNode.r < 0 || nextNode.r >= N || nextNode.c < 0 || nextNode.c >= M) continue;
                if (visit[nextNode.r][nextNode.c]) continue;
                if (board[nextNode.r][nextNode.c] == 'W') continue;
                q.offerLast(nextNode);
                visit[nextNode.r][nextNode.c] = true;
                maxStep = Math.max(maxStep, nextNode.step);
            }
        }
        return maxStep;
    }
}