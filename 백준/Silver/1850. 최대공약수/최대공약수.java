import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        while (true) {
            if (N % M == 0) break;
            long t = N % M;
            N = M;
            M = t;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }
}