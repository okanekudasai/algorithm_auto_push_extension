import java.io.*;
import java.util.*;

class Node {
    int index;
    long height;
    Node (int index, long height) {
        this.index = index;
        this.height = height;
    }

    @Override
    public String toString() {
        return "(순:" + this.index + ", 높:" + this.height + ")";
    }
}

public class Main {
    private static final int BUF_SIZE = 1 << 13;
    private static final byte[] buf = new byte[BUF_SIZE];
    private static int cursor = -1;
    private static int cursor_max = 0;

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

    static long readLong() throws IOException {
        long res = 0;
        while (true) {
            byte in = read();
            if (in <= 32) return res;
            res = (res << 3) + (res << 1) + (in & 15);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = readInt();
            if (N == 0) break;
            long [] arr = new long [N];
            for (int i = 0; i < N; i++) {
                arr[i] = readInt();
            }
            sb.append(solution(N, arr)).append('\n');
        }
        System.out.print(sb);
    }
    static long solution(int N, long [] data) {
        long maxSize = -1;
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int lastNodeIndex = -1;
            while (true) {
                if (stack.isEmpty()) break;
                Node lastNode = stack.peekLast();
                if (lastNode.height <= data[i]) break;
                stack.pollLast();
                maxSize = Math.max(maxSize, (i - lastNode.index) * lastNode.height);
                lastNodeIndex = lastNode.index;
            }
            if (lastNodeIndex == -1) lastNodeIndex = i;
            Node currentNode = new Node(lastNodeIndex, data[i]);
            stack.offerLast(currentNode);
        }
        while (true) {
            if (stack.isEmpty()) break;
            Node lastNode = stack.peekLast();
            stack.pollLast();
            maxSize = Math.max(maxSize, (N - lastNode.index) * lastNode.height);
        }
        return maxSize;
    }
}