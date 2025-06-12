import java.io.*;
import java.util.*;

public class Main {
    private static final int BUF_SIZE = 1 << 13;
    private static final byte [] buf = new byte [BUF_SIZE];
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
    public static void main(String [] args) throws IOException {
        int N = readInt();
        System.out.println(solution(N));
    }
    static long solution(int N) {
        if (N > 1023) return -1;
        List<Long> numList = new ArrayList<>();
        for (int digit = 1; digit <= 10; digit++) {
            makeNumber(0, 9, 1, digit, numList);
        }
        return numList.get(N - 1);
    }
    static void makeNumber(long result, int end, int level, int depthLimit, List<Long> numList) {
        if (level > depthLimit) {
            numList.add(result);
            return;
        }
        for (int i = 0; i <= end; i++) {
            makeNumber(result * 10 + i, i - 1, level + 1, depthLimit, numList);
        }
    }
}