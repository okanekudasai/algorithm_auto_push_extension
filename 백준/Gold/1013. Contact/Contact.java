import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String [] arg) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        String [] answer = new String [testcase];
        for (int T = 1; T <= testcase; T++) {
            char [] data = br.readLine().toCharArray();
            answer[T-1] = "NO";
            solution(data, answer, T-1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : answer) sb.append(s).append('\n');
        System.out.print(sb);
    }
    static String solution(char [] s, String [] answer, int i) {
        int index = 0;
        dfsing(s, index, answer, i);
        return null;
    }
    static void dfsing(char [] s, int index, String [] answer, int ai) {
        if (index >= s.length) {
            answer[ai] = "YES";
            return;
        }
        if (index + 1 < s.length && s[index] == '0' && s[index + 1] == '1') {
            dfsing(s, index + 2, answer, ai);
        }
        if (index + 2 < s.length && s[index] == '1' && s[index + 1] == '0' && s[index + 2] == '0') {
            int d = 3;
            while (true) {
                if (index + d >= s.length) return;
                if (s[index + d] == '0') d++;
                else break;
            }
            d++;
            while (true) {
                if (index + d >= s.length) break;
                if (s[index + d] == '1') d++;
                else break;
            }
            if (s[index + d - 2] == '1') dfsing(s, index + d-1, answer, ai);
            dfsing(s, index + d, answer, ai);
        }
        return;
    }
}
