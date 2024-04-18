import sys
input=sys.stdin.readline

N = int(input())
M = int(input())
print("Yes" if N == sum([i * j for (i, j) in [list(map(int, input().split(" "))) for _ in range(M)]]) else "No")