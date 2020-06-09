# 2193번. 이친수


n = int(input())

dp = [[0 for i in range(2)] for i in range(n+1)]
# dp[자리수][끝자리숫자]

dp[1][0] = 1
dp[1][1] = 1

# 끝자리 숫자가 0이면 그 앞자리는 아무거나
# 끝자리 숫자가 1이면 무조건 0

for i in range(2, n+1):
    dp[i][0] = dp[i-1][0]+dp[i-1][1]
    dp[i][1] = dp[i-1][0]

print(dp[n][1])
print(dp)
