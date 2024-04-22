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
        int [] data = new int [N+1];
        for (int i = 1; i <= N; i++) {
            int t = Integer.parseInt(st.nextToken());
            data[i] = data[i-1] + t;
        }
        int left = 0;
        int answer = data[1];
        if (data[1] < 0) {
            left = 1;
        }
        for (int right = 2; right <= N; right++) {
//            if (data[right-1] < data[right]) {
                answer = Math.max(answer, data[right] - data[left]);
//            } else {
                if (data[left] > data[right]) {
                    left = right;
                }
//            }
//            System.out.println(answer + " " + data[right] + " " + data[left]);
        }
        System.out.println(answer);
    }
}


/*

-3 -12 -22 -24

10 6 9 10 15 21 -14 -2 19 18

2 3 -1 2 6 2 8 13 8 9

-1 1
 */