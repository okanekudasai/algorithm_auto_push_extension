import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int scene = 1;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            String [] name = new String [N+1];
            for (int i = 1; i <= N; i++) {
                name[i] = br.readLine();
            }
            int remain = N * (N+1);
            for (int i = 0; i < 2 * N - 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                remain -= a;
            }
            sb.append(scene++).append(" ").append(name[remain]).append("\n");
        }
        System.out.print(sb);
    }
}