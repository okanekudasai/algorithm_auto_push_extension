// 문제 : 회전하는 큐
// 결과 :  / 속도: 80 / 메모리 : 11612
// 제출시각 : 24-01-12  2:8:35
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
​
public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> Ll = new LinkedList<>();
        for(int i = 1; i <= n; i++) Ll.add(i);
        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        for(int data = 0; data < m; data++) {
            int t = Integer.parseInt(st.nextToken());
            int it = Ll.indexOf(t);
            if (it <= n/2) {
                for(int i = 0; i < it; i++) {
                    Ll.offerLast(Ll.pollFirst());
                    answer++;
                }
            } else {
                for (int i = n-1; i >= it; i--) {
                    Ll.offerFirst(Ll.pollLast());
                    answer++;
                }
            }
            n--;
            Ll.pollFirst();
        }
        System.out.println(answer);
    }
}
