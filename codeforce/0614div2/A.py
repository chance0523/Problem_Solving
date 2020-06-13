import sys
input = sys.stdin.readline


t = int(input())

for _ in range(t):
    n, x = map(int, input().split())
    nList = list(map(int, input().split()))
    mList = [[[0, j-i+1] for j in range(n)] for i in range(n)]

    for i in range(n):
        for j in range(i, n):
            if i == j:
                mList[i][j][0] = nList[j]
            else:
                mList[i][j][0] = mList[i][j-1][0]+nList[j]
            mList[i][j][0] %= x
    # print(mList)
    ans = 0
    for i in range(n):
        for j in range(i, n):
            if mList[i][j][0] != 0:
                ans = max(ans, mList[i][j][1])
    if ans:
        print(ans)
    else:
        print(-1)
