// 문제 : 유기농 배추
// 결과 :  / 속도: 180 / 메모리 : 15880
// 제출시각 : 24-01-16  18:0:31
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
​
class Node {
    int r;
    int c;
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
}
​
public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [] [] delta = {{0,1},{1,0},{0,-1},{-1,0}};
        int tc = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= tc; testcase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int [] [] map = new int [r] [c];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int answer = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 1) {
                        answer++;
                        Stack<Node> stack = new Stack<>();
                        stack.push(new Node(i, j));
                        while (stack.size() > 0) {
                            Node s = stack.pop();
                            for (int [] d : delta) {
                                int next_r = s.r + d[0];
                                int next_c = s.c + d[1];
                                if (next_r < 0 || next_r >= r || next_c < 0 || next_c >= c) continue;
                                if (map[next_r][next_c] == 0) continue;
                                map[next_r][next_c] = 0;
                                stack.push(new Node(next_r, next_c));
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
