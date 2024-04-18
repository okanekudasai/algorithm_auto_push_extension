from collections import Counter
import sys
input=sys.stdin.readline

def 산술평균(data, N):
    return round(sum(data) / N)

def 중간값(data, N):
    return sorted(data)[N//2]

def 최빈값(data):
    count = sorted(Counter(data).items(), key = lambda x: (-x[1], x[0]))
    # print(count)
    if len(count) > 1 and count[0][1] == count[1][1]: return count[1][0]
    else: return count[0][0]

def 범위(data):
    return max(data) - min(data)

N = int(input())
data = [int(input()) for i in range(N)]


print(산술평균(data, N))

print(중간값(data, N))

print(최빈값(data))

print(범위(data))