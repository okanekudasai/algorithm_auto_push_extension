import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        if (s.length == 0) {
            System.out.println(0);
            return;
        }
        if (s[0].equals("")) System.out.println(s.length - 1);
        else System.out.println(s.length);
    }
}