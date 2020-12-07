# 15658번. 연산자 끼워넣기 (2)


import sys
input = sys.stdin.readline


def place(cnt, result, p, mi, mul, d):
    global minAns, maxAns
    if cnt == n:  # 연산자 다 썼을 때
        minAns = min(minAns, result)
        maxAns = max(maxAns, result)
        return
    if p:
        place(cnt+1, result+nList[cnt], p-1, mi, mul, d)
    if mi:
        place(cnt+1, result-nList[cnt], p, mi-1, mul, d)
    if mul:
        place(cnt+1, result*nList[cnt], p, mi, mul-1, d)
    if d:
        if result < 0:
            place(cnt+1, -(abs(result)//nList[cnt]), p, mi, mul, d-1)
        else:
            place(cnt+1, abs(result)//nList[cnt], p, mi, mul, d-1)


n = int(input())
nList = list(map(int, input().split()))
p, mi, mul, d = map(int, input().split())
minAns = 1e9+1
maxAns = -1e9-1

place(1, nList[0], p, mi, mul, d)

print(maxAns)
print(minAns)
