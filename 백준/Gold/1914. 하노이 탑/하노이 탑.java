import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        System.out.println(BigInteger.TWO.pow(N).subtract(BigInteger.ONE));
        if (N > 20) return;
        System.out.println(hanoing(1, 3, N));
    }
    static String hanoing(int s, int e, int K) {
        if (K == 0) return "";
        return
                hanoing(s, 6 - s - e, K-1) +
                s + " " + e + "\n" +
                hanoing(6 - s - e, e, K-1);
    }
}

