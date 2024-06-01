import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char [] [] data = new char [N] [N];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().toCharArray();
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean [] visit = new boolean[N];
            visit[i] = true;
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (data[i][j] == 'N') continue;
                if (!visit[j]) {
                    visit[j] = true;
                    count++;
                }
                for (int k = 0; k < N; k++) {
                    if (data[j][k] == 'N') continue;
                    if (!visit[k]) {
                        visit[k] = true;
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
