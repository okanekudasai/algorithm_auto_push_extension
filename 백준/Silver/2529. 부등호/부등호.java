import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        char [] data = new char [N+1];
        for (int i = 1; i <= N; i++) {
            data[i] = st.nextToken().charAt(0);
        }

        int [] made_array = new int [N+1];
        for (int i = 0; i <= N; i++) made_array[i] = -1;
        boolean [] used = new boolean [10];
        String [] answer = new String [2];

        dfsing(0, N, data, made_array, used, answer);
        System.out.println(answer[1] + '\n' + answer[0]);
    }

    static void dfsing(int level, int N, char [] data, int [] made_array, boolean [] used, String [] answer) {
        if (level == 0) {
            for (int i = 0; i <= 9; i++) {
                used[i] = true;
                made_array[0] = i;
                dfsing(1, N, data, made_array, used, answer);
                used[i] = false;
                made_array[0] = -1;
            }
        } else {
            if (level >= N+1) {
//                System.out.println("*"+Arrays.toString(made_array));
                StringBuilder sb = new StringBuilder();
                for (int i : made_array) {
                    sb.append(i);
                }
                if (answer[0] == null) answer[0] = sb.toString();
                answer[1] = sb.toString();
                return;
            }
            for (int i = 0; i <= 9; i++) {
                if (data[level] == '<' && made_array[level-1] >= i) continue;
                else if (data[level] == '>' && made_array[level-1] <= i) continue;
                if (used[i]) continue;
                used[i] = true;
                made_array[level] = i;
                dfsing(level+1, N, data, made_array, used, answer);
                used[i] = false;
                made_array[level] = -1;
            }
        }
    }
}
