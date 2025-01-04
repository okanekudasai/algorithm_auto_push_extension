import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int limit = B + 1;
        int [] number = new int [limit];
        int [] counter = new int [limit];
        for (int i = 0; i < limit; i++) number[i] = i;
        for (int i = 2; i < limit; i++) {
            for (int j = i; j < limit; j += i) {
                while (number[j] > 1) {
                    if (number[j] % i == 0) {
                        number[j] /= i;
                        counter[j]++;
                    } else {
                        break;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = A; i <= B; i++) {
            if (1 == counter[counter[i]]) answer++;
        }
        System.out.println(answer);
    }
}