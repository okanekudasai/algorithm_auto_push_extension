# 문제 : 부호
# 결과 :  / 속도: 280 / 메모리 : 111336
# 제출시각 : 24-01-12  1:48:11
import sys
​
input = sys.stdin.readline
​
answer = ""
for i in range(0, 3):
    N = int(input());
    value = sum(int(input()) for _ in range(0, N));
    print(0 if value == 0 else ('+' if value > 0 else '-'))
