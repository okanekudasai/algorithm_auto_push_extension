// 문제 : [PCCP 기출문제] 1번 / 붕대 감기
// 결과 :  / 속도: 0 / 메모리 : 0
// 제출시각 : 24-02-15  1:20:53
import java.util.*;
​
class Attack {
    int time;
    int damage;
    Attack(int time, int damage) {
        this.time = time;
        this.damage = damage;
    }
}
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        ArrayDeque<Attack> attack_q = new ArrayDeque<>();
        for (int [] a : attacks) {
            attack_q.offerLast(new Attack(a[0], a[1]));
        }
        
        int full_health = health;
        int present_time = 1;
        int success_count = 0;
        
        while(!attack_q.isEmpty()) {
            Attack a = attack_q.peekFirst();
            // System.out.println(a.time + " " + a.damage);
            if (a.time == present_time) {
                a = attack_q.pollFirst();
                success_count = 0;
                health -= a.damage;
                if (health <= 0) {

                    return -1;
                }
            } else {
                health = Math.min(full_health, health + bandage[1]);
                success_count++;
                if (success_count == bandage[0]) {
                    success_count = 0;
                    health = Math.min(full_health, health + bandage[2]);
                }
            }
            present_time++;
        }
        return health;
    }
}
