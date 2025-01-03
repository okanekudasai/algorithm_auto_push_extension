import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Loop1:
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int line = T / 2;
            HashMap<Long, Integer> counter = new HashMap<>();
            for (int j = 0; j < T; j++) {
                long value = Long.parseLong(st.nextToken());
                counter.merge(value, 1, Integer::sum);
                if (counter.get(value) > line) {
                    sb.append(value).append("\n");
                    continue Loop1;
                }
            }
            sb.append("SYJKGW").append("\n");
        }
        System.out.print(sb);
    }
}