import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> counter = new HashMap<>();
        int d = N;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            counter.putIfAbsent(b-a, 0);
            counter.put(b-a, counter.get(b-a)+1);
        }
        ArrayList<Integer> num = new ArrayList<>(counter.keySet());
        num.sort((o1, o2) -> o1 - o2);
        for (int i = 0; i < num.size(); i++) {
            d -= 2 * counter.get(num.get(i));
            if (d == 0) {
//                System.out.println(num.get(i) + " " + num.get(i+1));
                System.out.println(num.get(i+1) - num.get(i) + 1);
                return;
            }
        }
        System.out.println(1);
    }
}
