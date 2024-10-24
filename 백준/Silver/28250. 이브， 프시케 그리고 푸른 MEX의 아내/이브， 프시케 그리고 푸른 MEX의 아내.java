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
        int [] count = new int [3];
        int [] [] mex = {{1, 2, 1}, {2, 0, 0}, {1, 0, 0}};
        int firstNum = Integer.parseInt(st.nextToken());
        if (firstNum > 2) firstNum = 2;
        count[firstNum] = 1;
        long answer = 0;
        for (int i = 1; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t > 2) t = 2;
            int acc = 0;
            for (int j = 0; j < 3; j++) {
                acc += mex[t][j] * count[j];
            }
            count[t]++;
            answer += acc;
        }
        System.out.println(answer);
    }
}