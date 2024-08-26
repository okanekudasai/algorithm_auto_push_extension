import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int max_ana = -1;
        ArrayList<Integer> ana = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken()) + (i - 1);
            if (max_ana < num) {
                max_ana = num;
                ana.add(num);
                index.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        N = ana.size();
        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int g = 0; g < Q; g++) {
            int donbori = Integer.parseInt(st.nextToken());
            int answer = binarySearch(donbori, N, ana, index);
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
    static int binarySearch(int d, int N, ArrayList<Integer> ana, ArrayList<Integer> index) {
        int left = 0;
        int right = N;
        while (true) {
            if (left >= right) break;
            int mid = (left + right) / 2;
//            System.out.println(left + " " + mid + " " + right);
            if (d <= ana.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
//        System.out.println(ana.get(right) + "(" + index.get(right) + ")");
        return index.get(right);
    }
}
