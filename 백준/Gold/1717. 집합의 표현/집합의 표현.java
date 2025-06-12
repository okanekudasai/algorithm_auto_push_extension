
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String YES = "YES";
    static String NO = "NO";

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String [] s = new String [M];
        for (int i = 0; i < M; i++) {
            s[i] = br.readLine();
        }
        System.out.print(solution(N, s));
    }
    static String solution(int N, String [] data) {
        StringBuilder sb = new StringBuilder();

        int [] parent = new int [N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (String s : data) {
            StringTokenizer token = new StringTokenizer(s, " ");
            int type = Integer.parseInt(token.nextToken());
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());

            if (type == 0) unionSet(num1, num2, parent);
            else if (type == 1) sb.append(confirmSet(num1, num2, parent)).append('\n');
        }

        return sb.toString();
    }
    static void unionSet(int num1, int num2, int [] parent) {
        int parentOfNum1 = findParent(num1, parent);
        int parentOfNum2 = findParent(num2, parent);
        int a = Math.min(parentOfNum1, parentOfNum2);
        int b = Math.max(parentOfNum1, parentOfNum2);
        allocateParent(b, a, parent);
//        System.out.println(Arrays.toString(parent));
    }
    static String confirmSet(int num1, int num2, int [] parent) {
        int parentOfNum1 = findParent(num1, parent);
        int parentOfNum2 = findParent(num2, parent);

        if (parentOfNum1 == parentOfNum2) return YES;
        else return NO;
    }
    static int findParent(int n, int [] parent) {
        if (n == parent[n]) return n;

        return parent[n] = findParent(parent[n], parent);
    }
    static void allocateParent(int n, int numToBeParent, int [] parent) {
        int next = parent[n];
        parent[n] = numToBeParent;
        if (next == n) return;
        allocateParent(next, numToBeParent, parent);
    }
}