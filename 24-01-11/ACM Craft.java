// 문제 : ACM Craft
// 결과 :  / 속도: 1164 / 메모리 : 260724
// 제출시각 : 24-01-11  20:32:27
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
​
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기위한 변수를 선언해요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
​
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {
            // 입력을 받아요
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int [] build_time = new int [N+1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < N+1; i++) build_time[i] = Integer.parseInt(st.nextToken());
​
            // 그래프를 만들 변수를 선언해요
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
​
            // 진입차수를 기록하기 위한 변수를 선언해요
            int [] indegree = new int[N+1];
​
            for (int i = 1; i <= N; i++) {
                graph.put(i, new ArrayList<Integer>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                indegree[b]++;
            }
            int W = Integer.parseInt(br.readLine());
​
            int [] build_cost = new int [N+1];
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                    build_cost[i] = build_time[i];
                }
            }
​
            while (q.size() > 0) {
                int n = q.poll();
                for (int i : graph.get(n)) {
                    indegree[i]--;
                    build_cost[i] = Math.max(build_cost[i], build_cost[n] + build_time[i]);
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
​
//            System.out.println(Arrays.toString(build_cost));
            sb.append(build_cost[W] + "\n");
        }
        System.out.println(sb);
    }
}
