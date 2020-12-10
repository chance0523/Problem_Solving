# 16210번. DSHS Bank


import sys
from bisect import bisect_left
input = sys.stdin.readline

# 참고 : https://algopoket.tistory.com/2

n = int(input())
nList = [[0, 0]]
xList = [0]
yList = [0]
for i in range(n):
    x, y = map(int, input().split())
    nList.append([x, y])
    xList.append(x)
    yList.append(y)
xList.sort()
yList.sort()

pList = [[0, 0] for i in range(n + 1)]

for i in range(1, n+1):
    pList[i][0] = pList[i - 1][0] + xList[i]
    pList[i][1] = pList[i - 1][1] + yList[i]

m = 1e9
ans = 1

for i in range(1, n+1):
    x = bisect_left(xList, nList[i][0])
    y = bisect_left(yList, nList[i][1])
    s = pList[n][1] - pList[y][1] - pList[y - 1][1] - (n - y) * nList[i][1] + (
        y - 1) * nList[i][1] + pList[n][0] - pList[x][0] - pList[x - 1][0] - (n - x) * nList[i][0] + (x - 1) * nList[i][0]
    if s < m:
        m = s
        ans = i
print(ans)
