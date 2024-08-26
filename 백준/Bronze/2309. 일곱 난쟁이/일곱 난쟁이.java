import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int t = Integer.parseInt(br.readLine());
            set.add(t);
            sum += t;
        }
        int ex = sum - 100;
        int n1, n2;
        for (int num : set) {
            if (ex - num == num) continue;
            if (set.contains(ex - num)) {
//                System.out.println(num + " " + (ex-num));
                set.remove(num);
                set.remove(ex-num);
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        for (int num : list) sb.append(num).append('\n');
        System.out.println(sb);
    }
}