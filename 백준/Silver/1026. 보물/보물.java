import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> data = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) data.offer(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> stand = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < N; i++) stand.offer(Integer.parseInt(st.nextToken()));

        int S = 0;
        for (int i = 0; i < N; i++) {
            int a = data.poll();
            int b = stand.poll();
//            System.out.println(a + " " + b);
            S += a * b;
        }

        System.out.println(S);
    }
}
