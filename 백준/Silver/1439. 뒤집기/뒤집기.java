import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static public void main(String [] args) throws IOException {
        char [] data = br.readLine().toCharArray();
        int counter = 0;
        int type = '2';
        for (char c : data) {
            if (c == type) continue;
            type = c;
            counter++;
        }
        System.out.println(counter/ 2);
    }
}