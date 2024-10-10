k = int(input().split(" ")[1])
print(sorted(list(map(int, input().split(" "))), key = lambda x: -x)[k-1])