import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "{";
        String s = br.readLine();
        int N = s.length();
        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k >= 0; k--) sb.append(s.charAt(k));
                for (int k = j; k >= i+1; k--) sb.append(s.charAt(k));
                for (int k = N-1; k >= j+1; k--) sb.append(s.charAt(k));
                if (answer.compareTo(sb.toString()) > 0) answer = sb.toString();
            }
        }
        System.out.println(answer);
    }
}