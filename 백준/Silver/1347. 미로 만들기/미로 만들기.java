import java.io.*;
import java.util.*;

class Node {
    int r, c;
    Node (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char [] command = br.readLine().toCharArray();
        int [] [] direction = {{1,0},{0,-1},{-1,0},{0,1}};
        int d = 0;
        ArrayList<Node> footPrint = new ArrayList<>();
        footPrint.add(new Node(0, 0));
        int R = 1; int C = 1;

        for (char c : command) {
            if (c == 'R') d = (d + 1) % 4;
            else if (c == 'L') d = (d + 3) % 4;
            else if (c == 'F') {
                Node pre = footPrint.get(footPrint.size() - 1);
                Node now = new Node(pre.r + direction[d][0], pre.c + direction[d][1]);
                footPrint.add(now);
                if (now.r < 0) {
                    for (Node n : footPrint) {
                        n.r += 1;
                    }
                    R += 1;
                } else if (now.c < 0) {
                    for (Node n : footPrint) {
                        n.c += 1;
                    }
                    C += 1;
                } else if (now.r >= R) {
                    R += 1;
                } else if (now.c >= C) {
                    C += 1;
                }
            }
        }
        boolean [] [] board = new boolean [R] [C];
        for (Node n : footPrint) {
            board[n.r][n.c] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append((board[i][j]) ? '.' : '#');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}