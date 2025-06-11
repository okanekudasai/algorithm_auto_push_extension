
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(),  " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }

    static int solution(int N, int K) {
        String binaryNumber = makeBinary(N);
        char [] binaryNumberToCharArray = binaryNumber.toCharArray();
        int binaryLength = binaryNumber.length();
        int counter = 0;
        for (char c : binaryNumberToCharArray) {
            if (c == '1') counter++;
        }
        if (counter <= K) {
            return 0;
        }
        int [] binaryHelper = new int [binaryLength];
        counter = 0;
        for (int i = binaryLength - 1; i >= 0; i--) {
            if (counter >= K) {
                if (binaryNumberToCharArray[i] == '0') binaryHelper[i] = 1;
                else binaryHelper[i] = 0;
                continue;
            }
            if (binaryNumberToCharArray[i] == '1') counter++;
        }
        int answer = 0;
        int digitHelper = 1;
        for (int i = 0; i < binaryLength; i++) {
            answer += binaryHelper[i] * digitHelper;
            digitHelper *= 2;
        }
        answer++;
        return answer;
    }

    static String makeBinary(int N) {
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            sb.append(N % 2);
            N /= 2;
        }
        return sb.toString();
    }
}