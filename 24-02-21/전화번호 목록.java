// 문제 : 전화번호 목록
// 결과 :  / 속도: 0 / 메모리 : 0
// 제출시각 : 24-02-21  10:34:21
import java.util.*;
​
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet();
        for (String s : phone_book) set.add(s);

        for (String s : phone_book) {
            StringBuilder sb = new StringBuilder();
            set.remove(s);
            for (char c : s.toCharArray()) {
                sb.append(c);
                // System.out.println(sb);
                if (set.contains(sb.toString())) return false;
            }
            set.add(s);
        }
        return true;
    }
}
