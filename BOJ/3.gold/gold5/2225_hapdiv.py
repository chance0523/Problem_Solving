# 2225번. 분해합


n, k = map(int, input().split())

dp = [[0 for i in range(k+1)] for i in range(n+1)]

# dp[n][k] : n을 k개 정수의 합으로 표현 경우의 수

for i in range(n+1):
    dp[i][1] = 1

mod = 1000000000

for i in range(1, k+1):
    for j in range(n+1):
        for p in range(j+1):
            dp[j][i] += dp[p][i-1]
            # 계속 mod로 나눠주면서
            dp[j][i] %= mod

print(dp[n][k])
