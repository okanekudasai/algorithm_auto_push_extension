// 문제 : 물통
// 결과 :  / 속도: 120 / 메모리 : 23256
// 제출시각 : 24-01-31  18:23:52
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
​
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
​
        st = new StringTokenizer(br.readLine());
        int [] limit = new int [3];
        limit[0] = Integer.parseInt(st.nextToken());
        limit[1] = Integer.parseInt(st.nextToken());
        limit[2] = Integer.parseInt(st.nextToken());
        boolean [] [] [] visit = new boolean [limit[0]+1] [limit[1]+1] [limit[2]+1];
        TreeSet<Integer> answer = new TreeSet<>();
        answer.add(limit[2]);
        visit[0][0][limit[2]] = true;
​
        ArrayDeque<int []> q = new ArrayDeque<>();
        q.offerLast(new int [] {0,0,limit[2]});
        while(!q.isEmpty()) {
            int[] current = q.pollFirst();
​
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (i == j) continue;
                    int [] next = make(new int [] {current[0], current[1], current[2]}, limit, visit, i, j);
//                    System.out.println(Arrays.toString(current) + " " + Arrays.toString(next) + " " + i + " " + j);
                    if (next != null) {
                        if (next[0] == 0) answer.add(next[2]);
                        q.offerLast(next);
                    }
                }
            }
        }
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    static int [] make (int [] current, int [] limit, boolean [] [] [] visit, int from, int to) {
        if (current[from] == 0) return null;
        if (current[to]+current[from] > limit[to]) {
            current[from] = current[from]+current[to]-limit[to];
            current[to] = limit[to];
        } else {
            current[to] = current[from] + current[to];
            current[from] = 0;
        }
        if (visit[current[0]][current[1]][current[2]]) return null;
        visit[current[0]][current[1]][current[2]] = true;
        return current;
    }
}
