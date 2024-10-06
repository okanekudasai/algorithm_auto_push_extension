import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testcase = 1; testcase <= T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            char [] data = br.readLine().toCharArray();
            sb.append(solution(data)).append('\n');
        }
        System.out.print(sb);
    }
    static class Node {
        char value;
        char pre;
        Node (char value, char pre) {
            this.value = value;
            this.pre = pre;
        }
    }
    static String solution(char [] data) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.offerLast(new Node('\0','\0'));
        for (char c : data) {
            Node preNode = stack.peekLast();
            if (c == 'B') inputB(preNode, stack);
            else stack.offerLast(new Node('A', preNode.value));
        }
        stack.pollFirst();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Node n = stack.pollFirst();
            sb.append(n.value);
        }
        return sb.toString();
    }
    static void inputB(Node preNode, ArrayDeque<Node> stack) {
        if (preNode.value == 'B' && preNode.pre == 'A') {
            stack.pollLast();
            stack.pollLast();
            inputB(stack.peekLast(), stack);
            stack.offerLast(new Node('A', stack.peekLast().value));
        } else {
            stack.offerLast(new Node('B', preNode.value));
        }
    }
}
