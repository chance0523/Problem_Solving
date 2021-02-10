import sys
input = sys.stdin.readline


n, k = map(int, input().split())
kList = []
for i in range(n):
    kList.append(list(map(int, input().split())))

kList.sort(key=lambda x: (-x[1], -x[2], -x[3]))
for i in range(n):
    if kList[i][0] == k:
        idx = i
for i in range(n):
    if kList[idx][1:] == kList[i][1:]:
        print(i + 1)
        break
