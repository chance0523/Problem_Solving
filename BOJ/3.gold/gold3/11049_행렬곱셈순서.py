# 11049번. 행렬 곱셈 순서


# only PyPy
n = int(input())
nList = []
INF = 2 ** 32
for _ in range(n):
    r, c = map(int,input().split())
    nList.append([r,c])
dp = [[0 for _ in range(n)] for _ in range(n)]
for i in range(1, n):
    for j in range(n - i):
        x= j + i
        dp[j][x] = INF
        for k in range(j,x):
            dp[j][x] = min(dp[j][x], dp[j][k] + dp[k + 1][x] + nList[j][0] * nList[k][1] * nList[x][1])
print(dp[0][n-1])