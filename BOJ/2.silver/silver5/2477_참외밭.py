# 2477번. 참외밭


import sys
input = sys.stdin.readline

n = int(input())
nList = []
w = h = w2 = h2 = 0
for i in range(6):
    dir, l = map(int, input().split())
    nList.append(l)
    # 가로와 세로의 최대값을 정해줌 (큰 사각형)
    if i % 2 == 0:
        w = max(w, l)
    else:
        h = max(h, l)

for i in range(6):
    if i % 2 == 0 and h == nList[(i+5) % 6]+nList[(i+1) % 6]:
        w2 = nList[i]
    elif i % 2 == 1 and w == nList[(i+5) % 6]+nList[(i+1) % 6]:
        h2 = nList[i]
print(n*(w*h - w2*h2))
