import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int MIN = Math.min(L, W);
        MIN = Math.min(MIN, H);

        double left = 0;
        double right = MIN;

        int count = 0;
        while (left < right) {
            double mid = (left + right) / 2;
            if (Math.floor(L / mid) * Math.floor(W / mid) * Math.floor(H / mid) >= N) {
                left = mid;
            } else {
                right = mid;
            }
            if (count++ > 100000) break;
        }
        System.out.println(left);
    }
}