import sys
input = sys.stdin.readline


t = int(input())


def func(i, j, cnt):
    global mincnt
    if(box[i][j] == 'C'):
        if(mincnt > cnt):
            mincnt = cnt
            return
    # just go
    if (box[i][j] == 'R' and j != m-1):
        func(i, j+1, cnt)
    elif (box[i][j] == 'D' and i != n-1):
        func(i+1, j, cnt)
    # change
    if (box[i][j] == 'R' and i != n-1):
        func(i+1, j, cnt+1)
    elif (box[i][j] == 'D' and j != m-1):
        func(i, j+1, cnt+1)


for _ in range(t):
    n, m = map(int, input().split())
    box = [[] for i in range(n)]
    for i in range(n):
        box[i] = list(input().rstrip())
    cntList = []
    mincnt = 1e9
    for i in range(n):
        for j in range(m):
            func(i, j, 0)
            cntList.append(mincnt)
    print((cntList))
    # print(mincnt)
