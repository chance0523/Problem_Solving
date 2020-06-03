# 11727번. 2×n 타일링 2


import sys
input = sys.stdin.readline

n = int(input())
dp = [0 for i in range(n+1)]
dp[0] = 1
dp[1] = 1
# dp[2] = 3 이걸 쓰면 n=1인 경우 때문에 런타임 에러
# dp[3] = dp[1]*2+dp[2]
# dp[n] = (dp[n-1]+dp[n-2]*2)
for i in range(2, n+1):
    dp[i] = (dp[i-1]+dp[i-2]*2) % 10007
print(dp[n])
