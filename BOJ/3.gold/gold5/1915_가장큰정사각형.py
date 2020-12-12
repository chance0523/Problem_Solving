# 1915번. 가장 큰 정사각형


n, m = map(int, input().split())

nList = [list(map(int, input().rstrip())) for i in range(n)]

ans = 0

for i in range(n):
    for j in range(m):
        if i and j and nList[i][j] == 1:
            # 11
            # 11
            nList[i][j] += min(nList[i - 1][j], nList[i]
                               [j - 1], nList[i - 1][j - 1])
        ans = max(ans, nList[i][j])

print(ans**2)
