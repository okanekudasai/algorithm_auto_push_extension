import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//class Node {
//    int r, c;
//    Node (int r, int c) {
//        this.r = r;
//        this.c = c;
//    }
//}
public class Main {

//    static int [] [] delta = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testcase = 1; testcase <= T; testcase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(solution(b-a)).append("\n");
        }
        System.out.print(sb);
    }
    static long solution(double v) {
        long stand = (long) Math.ceil(Math.sqrt(v+0.25) - 0.5);
        if (v <= stand * (stand+1) / 2 + stand * (stand-1) / 2) return stand * 2 - 1;
        return stand * 2;
    }
}
