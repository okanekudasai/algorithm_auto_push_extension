import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        if (w * 2 <= s) {
            System.out.println((long)(a+b) * w);
        } else if (w < s && w * 2 > s) {
            int minNum = Math.min(a, b);
            int maxNum = Math.max(a, b);
            System.out.println((long)minNum * s + (long)(maxNum - minNum) * w);
        } else {
            if ((a+b) % 2 == 0) System.out.println((long)Math.max(a, b) * s);
            else System.out.println(((long)Math.max(a, b) - 1) * s + w);
        }
    }

}