import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int [] data = new int [N];
        for (int i = 0; i < N; i++) data[i] = Integer.parseInt(st.nextToken());

        int [] count = new int [N];
        count[0] = 1;
        int answer = 1;
        for (int i = 1; i < N; i++) {
            int sum = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (data[i] <= data[j] || sum >= count[j]) continue;
                sum = count[j];
            }
            count[i] = sum + 1;
            answer = Math.max(answer, count[i]);
        }
//        System.out.println(Arrays.toString(count));
        System.out.println(answer);
    }
}