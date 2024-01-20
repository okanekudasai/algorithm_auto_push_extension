// 문제 : 가장 많이 받은 선물
// 결과 :  / 속도: 0 / 메모리 : 0
// 제출시각 : 24-01-20  11:14:18
        }
        
        for (String s : gifts) {
            String [] k = s.split(" ");
            String a = k[0];
            String b = k[1];
            map.get(a).put(b, map.get(a).get(b)+1);
            gift_point.put(a, gift_point.get(a) + 1);
            gift_point.put(b, gift_point.get(b) - 1);
        }
        // System.out.println(gift_point);
        // System.out.println(map);
        
        for (int i = 0; i < friend_length; i++) {
            for (int j = i+1; j < friend_length; j++) {
                String a = friends[i];
                String b = friends[j];
                
                int a_give = map.get(a).get(b);
                int b_give = map.get(b).get(a);
                if (a_give + b_give > 0 && a_give != b_give) {
                    if (a_give > b_give) {
                        answer.put(a, answer.get(a) + 1);
                    } else if (a_give < b_give) {
                        answer.put(b, answer.get(b) + 1);
                    }
                } else {
                    if (gift_point.get(a) > gift_point.get(b)) {
                        answer.put(a, answer.get(a) + 1);
                    } else if (gift_point.get(a) < gift_point.get(b)) {
                        answer.put(b, answer.get(b) + 1);
                    }
                }
            }
        }
        int real_answer = -1;
        for (int i : answer.values()) real_answer = Math.max(real_answer, i);

        return real_answer;
    }
}
