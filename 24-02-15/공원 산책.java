// 문제 : 공원 산책
// 결과 :  / 속도: 0 / 메모리 : 0
// 제출시각 : 24-02-15  1:50:4
import java.util.*;
​
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int R = park.length;
        int C = park[0].length();
        char [] [] board = new char [R] [C];
        int [] answer = {0, 0};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = park[i].charAt(j);
                if (board[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        HashMap<Character, int []> delta = new HashMap<>();
        delta.put('N', new int [] {-1, 0});
        delta.put('S', new int [] {1, 0});
        delta.put('W', new int [] {0, -1});
        delta.put('E', new int [] {0, 1});
        Loop1:
        for (String r : routes) {
            int [] v = delta.get(r.charAt(0));
            int s = r.charAt(2) - '0';
            int next_r = answer[0];
            int next_c = answer[1];
            for (int i = 0; i < s; i++) {
                next_r += v[0];
                next_c += v[1];
                if (next_r < 0 || next_r >= R || next_c < 0 || next_c >= C) continue Loop1;
                if (board[next_r][next_c] == 'X') continue Loop1;
            }
            answer[0] = next_r;
            answer[1] = next_c;
        }

    }
}
