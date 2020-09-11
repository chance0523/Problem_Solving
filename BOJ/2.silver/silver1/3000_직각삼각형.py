# 3000번. 직각삼각형


import sys
input = sys.stdin.readline

n = int(input())
x = [0 for i in range(111111)]
y = [0 for i in range(111111)]

box = []
for i in range(n):
    a, b = map(int, input().split())
    box.append([a, b])
    x[a] += 1
    y[b] += 1

total = 0
for i in range(n):
    s = (x[box[i][0]]-1)*(y[box[i][1]]-1)
    if s < 0:
        continue
    total += s
print(total)
