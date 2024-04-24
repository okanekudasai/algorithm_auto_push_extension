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
        int [] data = new int [N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int [] maxed = new int [N];
        for (int i = 0; i < N; i++) {
            maxed[i] = data[i];
            for (int j = 0; j < i; j++) {
                maxed[i] = Math.max(maxed[i], maxed[j] + maxed[i-j-1]);
            }
        }
        System.out.println(maxed[N-1]);
    }
}