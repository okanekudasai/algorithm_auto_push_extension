import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int [] alphabet = new int ['z' - 'a' + 1];
            int index = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int p = s.charAt(j) - 'a';
                if (alphabet[p] == 0) {
                    sb.append(index);
                    alphabet[p] = index++;
                } else {
                    sb.append(alphabet[p]);
                }
            }
            s = sb.toString();
            if (map.get(s) == null) map.put(s, 0);
            map.put(s, map.get(s) + 1);
        }
        int answer = 0;
        for (String k : map.keySet()) {
            int t = map.get(k);
            answer += t * (t-1) / 2;
        }
        System.out.println(answer);
    }
}