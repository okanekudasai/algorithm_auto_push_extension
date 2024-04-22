import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [] number = new int [N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        int [] operator = new int [5];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        int [] dfs_array = new int [N];
        int [] answer = new int [2];
        answer[0] = Integer.MIN_VALUE;
        answer[1] = Integer.MAX_VALUE;
        dfsing(1, N, number, operator, dfs_array, answer);
        System.out.println(answer[0] + "\n" + answer[1]);
    }
    static void dfsing(int level, int N, int [] number, int [] operator, int [] dfs_array, int [] answer) {
        if (level >= N) {
            int result = number[0];
            for (int i = 1; i < N; i++) {
                if (dfs_array[i] == 1) {
                    result += number[i];
                } else if (dfs_array[i] == 2) {
                    result -= number[i];
                } else if (dfs_array[i] == 3) {
                    result *= number[i];
                } else if (dfs_array[i] == 4) {
                    result /= number[i];
                }
            }
            answer[0] = Math.max(answer[0], result);
            answer[1] = Math.min(answer[1], result);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            if (operator[i] <= 0) continue;
            operator[i]--;
            dfs_array[level] = i;
            dfsing(level+1, N, number, operator, dfs_array, answer);
            dfs_array[level] = 0;
            operator[i]++;
        }
    }
}
