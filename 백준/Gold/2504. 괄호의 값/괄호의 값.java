import java.io.*;
import java.util.*;

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

    static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            byte in = read();
            if (in <= 32) return sb.toString();
            sb.append((char) in);
        }
    }

    public static void main(String[] args) throws IOException {
        String s = readString();
        System.out.println(solution(s));
    }

    static int solution(String s) {
        char [] data = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : data) {
            boolean result = handleCharacter(c, stack);
            if (!result) return 0;
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            int p = stack.poll();
            if (p < 0) return 0;
            answer += p;
        }
        return answer;
    }

    static boolean handleCharacter(char c, Deque<Integer> stack) {
        if (c == '(') {
            stack.offerLast(-1);
        } else if (c == '[') {
            stack.offerLast(-2);
        } else {
            int accumulator = 0;
            while (true) {
                if (stack.isEmpty()) return false;
                int lastChar = stack.peekLast();
                if (c == ')' && lastChar == -2) return false;
                if (c == ']' && lastChar == -1) return false;
                if (c == ')' && lastChar == -1) break;
                if (c == ']' && lastChar == -2) break;
                accumulator += stack.pollLast();
            }
            stack.pollLast();
            int result = 0;
            if (c == ')' && accumulator == 0) result = 2;
            else if (c == ']' && accumulator == 0) result = 3;
            else if (c == ')') result = accumulator * 2;
            else if (c == ']') result = accumulator * 3;
            stack.offerLast(result);
        }
        return true;
    }
}