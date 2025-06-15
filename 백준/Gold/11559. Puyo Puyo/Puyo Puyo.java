import java.io.*;
import java.util.*;

class Node {
    int r, c;
    Node (int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "(" + this.r + ", " + this.c + ")";
    }
}
public class Main {
    static private final int BUF_SIZE = 1 << 13;
    static private final byte [] buf = new byte [BUF_SIZE];
    static private int cursor = -1;
    static private int cursor_max = 0;

    static private int [] [] delta = {{0,1},{1,0},{0,-1},{-1,0}};
    static byte read() throws IOException {
        if (++cursor == cursor_max) {
            cursor_max = System.in.read(buf, 0, BUF_SIZE);
            cursor = 0;
        }
        return buf[cursor];
    }
    static char readChar() throws IOException {
        return (char) read();
    }
    static public void main(String [] args) throws IOException {
        char [] [] board = new char [12] [6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = readChar();
            }
            read();
        }
        System.out.println(solution(board));
    }
    static int solution(char [] [] board) {
        int answer = 0;
        while(true) {
            boolean isFinished = doPuyo(board);
            doGravity(board);

            if (isFinished) break;
            answer++;
        }
        return answer;
    }
    static boolean doPuyo(char [] [] board) {
        boolean finished = true;
        boolean [] [] visit = new boolean [12] [6];
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (visit[i][j]) continue;
                if (board[i][j] == '.') continue;
                char color = board[i][j];
                List<Node> nodeList = new ArrayList<>();
                Deque<Node> q = new ArrayDeque<>();
                Node startNode = new Node(i, j);
                visit[startNode.r][startNode.c] = true;
                q.offerLast(startNode);
                nodeList.add(startNode);
                while (!q.isEmpty()) {
                    Node currentNode = q.pollFirst();
                    for (int [] d : delta) {
                        Node nextNode = new Node(currentNode.r + d[0], currentNode.c + d[1]);
                        if (nextNode.r < 0 || nextNode.r >= 12 || nextNode.c < 0 || nextNode.c >= 6) continue;
                        if (visit[nextNode.r][nextNode.c]) continue;
                        if (board[nextNode.r][nextNode.c] != color) continue;
                        visit[nextNode.r][nextNode.c] = true;
                        q.offerLast(nextNode);
                        nodeList.add(nextNode);
                    }
                }
                if (nodeList.size() >= 4) {
                    finished = false;
                    for (Node node : nodeList) {
                        board[node.r][node.c] = '.';
                    }
                }
            }
        }
        return finished;
    }
    static void doGravity(char [] [] board) {
        for (int i = 0; i < 6; i++) {
            int index = 11;
            char [] temp = new char [12];
            for (int j = 11; j >= 0; j--) {
                if (board[j][i] == '.') continue;
                temp[index--] = board[j][i];
            }
            for (int j = 11; j > index; j--) {
                board[j][i] = temp[j];
            }
            for (int j = index; j >= 0; j--) {
                board[j][i] = '.';
            }
        }
    }
}