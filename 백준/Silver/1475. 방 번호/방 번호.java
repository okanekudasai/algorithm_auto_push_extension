import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] data = br.readLine().toCharArray();
        int [] counter = new int [10];
        for (char c : data) {
            counter[(c - '0' == 9) ? 6 : c - '0']++;
        }
        counter[6]++;
        counter[6] /= 2;
        int answer = -1;
        for (int i : counter) answer = Math.max(answer, i);
        System.out.println(answer);
    }
}