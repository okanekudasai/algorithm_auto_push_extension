input = open(0).readline
s, t = input().split()
a, b = "", ""
for i in s[::-1]: a += i
for i in t[::-1]: b += i
a = int(a)
b = int(b)
temp = str(a + b)
answer = ""
for i in temp[::-1]: answer += i
print(int(answer))