import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] [] graph = new int [N+1] [N+1];
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a][b] = d;
            graph[b][a] = d;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solution(a, b, graph, N);
        }
    }
    static void solution(int start, int end, int [] [] graph, int N) {
        boolean [] visit = new boolean [N+1];
        visit[start] = true;
        dfsing(start, end, graph, visit, N, 0);
    }
    static void dfsing(int present, int target, int [] [] graph, boolean [] visit, int N, int distance) {
//        System.out.println("::" + present + " " + distance + " " + target);
        if (present == target) {
            System.out.println(distance);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (graph[present][i] <= 0 || visit[i]) continue;
            visit[i] = true;
            dfsing(i, target, graph, visit, N, distance + graph[present][i]);
            visit[i] = false;
        }
    }
}