# 문제 : 2차원 동전 뒤집기
# 결과 :  / 속도: 0 / 메모리 : 0
# 제출시각 : 24-02-01  20:18:39
from itertools import product
​
def solution(beginning, target):
    r, c = len(beginning), len(beginning[0])
    r_begin = [[int(not el) for el in row] for row in beginning]
    answer = 21
    for i in product((False, True), repeat = r):

        temp = i.count(True)
        for j in range(c):
            if any(source[i][j] != target[i][j] for i in range(r)):
                for ii in range(r):
                    source[ii][j] = int(not source[ii][j])
                temp += 1
                continue
        if source == target: answer = min(answer, temp)
    return -1 if answer == 21 else answer
