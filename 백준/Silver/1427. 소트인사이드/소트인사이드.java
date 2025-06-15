import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static public void main(String [] args) throws IOException {
        char [] s = br.readLine().toCharArray();
        Arrays.sort(s);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) sb.append(s[i]);
        System.out.println(sb.toString());
    }
}