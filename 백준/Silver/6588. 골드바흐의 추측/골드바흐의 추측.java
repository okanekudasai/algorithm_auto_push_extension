import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> data = new ArrayList<>();
        int max_data = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int testcase = 1; testcase <= 100000; testcase++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            data.add(N);
            max_data = Math.max(max_data, N);
        }
        boolean [] prime = new boolean [max_data+1];
        for (int i = 2; i <= max_data; i++) prime[i] = true;
        int prime_count = 0;
        for (int i = 2; i <= max_data; i++) {
            if (!prime[i]) continue;
            prime_count++;
            for (int j = i*2; j <= max_data; j += i) {
                prime[j] = false;
            }
        }
        int [] prime_array = new int [prime_count];
        int index = 0;
        for (int i = 2; i <= max_data; i++) {
            if (!prime[i]) continue;
            prime_array[index] = i;
            index++;
        }

        for (int i : data) {
            sb.append(solution(i, prime_array, prime));
        }
        System.out.print(sb);
    }
    static String solution(int N, int [] prime, boolean [] prime_check) {
        for (int i = 0; i < prime.length-1; i++) {
            if (N < prime[i]) break;
            int t = N - prime[i];
            if (!prime_check[t]) continue;
            return N + " = " + prime[i] + " + " + t + '\n';
        }
        return "Goldbach's conjecture is wrong.";
    }
}
