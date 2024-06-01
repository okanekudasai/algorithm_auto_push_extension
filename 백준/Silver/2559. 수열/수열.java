import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int [] data = new int [N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 0; i < K; i++) {
            count += data[i];
        }
        int answer = count;
        int pin = K;
        while (pin < N) {
            count = count - data[pin-K] + data[pin];
            answer = Math.max(answer, count);
            pin++;
//            System.out.println(count);
        }
        System.out.println(answer);
    }
}
