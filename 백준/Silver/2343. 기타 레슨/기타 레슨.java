import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] data = new int [N];
        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            right += data[i];
            left = Math.max(left, data[i]);
        }

        while (true) {
//            System.out.println(left + " " + right);
            if (left >= right) break;

            int mid = (left + right) / 2;

            int acc = 0;
            int count = 1;
            boolean need_big = false;
            for (int i : data) {
                if (acc + i > mid) {
                    acc = i;
                    count++;
                } else acc += i;
            }

//            System.out.println("*" + count);
            if (count > M) {
                need_big = true;
            }

            if (need_big) left = mid+1;
            else right = mid;
        }
        System.out.println(left);
    }
}
