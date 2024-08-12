import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char [] data = br.readLine().toCharArray();
        int N = data.length;
        int stack = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (data[i] == ')' && data[i-1] == '(') {
                stack--;
//                System.out.println(stack);
                answer += stack;
            } else if (data[i] == ')' && data[i-1] == ')') {
                stack--;
                answer++;
            } else {
                stack++;
            }
        }
//        System.out.println(stack);
        System.out.println(answer);
    }
}
