# 11650번. 좌표 정렬하기

n = int(input())
cList = []
for i in range(n):
    x, y = map(int, input().split())
    cList.append((x, y))

cList.sort()

for x, y in cList:
    print(x, y)
