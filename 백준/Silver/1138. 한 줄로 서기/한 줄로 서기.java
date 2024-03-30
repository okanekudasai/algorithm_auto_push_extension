import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int [] data = new int [N+1];
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int [] answer = new int [N+1];
        boolean [] visit = new boolean[N+1];
        Loop1:
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visit[j]) continue;
                int cnt = 0;
                for (int k = 1; k < i; k++) {
                    if (j < answer[k]) cnt++;
                }
                if (cnt == data[j]) {
                    answer[i] = j;
                    visit[j] = true;
//                    System.out.println(Arrays.toString(answer));
                    continue Loop1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(answer[i]).append(" ");
        System.out.println(sb);
    }
}
