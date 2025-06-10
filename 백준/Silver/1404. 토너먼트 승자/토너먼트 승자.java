
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int [] [] [] opponent =
            {
                    {{}, {1}, {2, 3}, {4, 5, 6, 7}},
                    {{}, {0}, {2, 3}, {4, 5, 6, 7}},
                    {{}, {3}, {0, 1}, {4, 5, 6, 7}},
                    {{}, {2}, {0, 1}, {4, 5, 6, 7}},
                    {{}, {5}, {6, 7}, {0, 1, 2, 3}},
                    {{}, {4}, {6, 7}, {0, 1, 2, 3}},
                    {{}, {7}, {4, 5}, {0, 1, 2, 3}},
                    {{}, {6}, {4, 5}, {0, 1, 2, 3}},
            };
        double [] [] possibility = new double [4] [8];
        for (int i = 0; i < 8; i++) possibility[0][i] = 1.0;

        int [] data = new int [28];
        st = new StringTokenizer(br.readLine(), " ");

        int [] [] winningSquare = new int [8] [8];
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 8; j++) {
                int p = Integer.parseInt(st.nextToken());
                winningSquare[i][j] = p;
                winningSquare[j][i] = 100 - p;
            }
        }
        for (int i = 0; i < 8; i++) winningSquare[i][i] = -1;

        for (int round = 1; round <= 3; round++) {
            fighting(round, possibility, winningSquare, opponent);
        }

        for (double answer : possibility[3]) {
            System.out.print(answer + " ");
        }
    }
    static void fighting(int round, double [] [] possibility, int [] [] winningSquare, int [] [] [] opponent) {
        for (int player = 0; player < 8; player++) {
            for (int away : opponent[player][round]) {
                possibility[round][player] += possibility[round - 1][player] * (possibility[round - 1][away] * winningSquare[player][away]);
            }
            possibility[round][player] /= 100;
        }
    }
}