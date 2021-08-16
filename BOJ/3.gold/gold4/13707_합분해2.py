# 13707번. 합분해 2

n, k = map(int, input().split())
# 기본적인 중복조합
# kHn = n+k-1Cn
mod = 1000000000

dp = [0 for i in range(12000)]
dp[0] = 1
dp[1] = 1

for i in range(2, n + k):
    dp[i] = 1
    for j in range(i - 1, 0, -1):
        dp[j] = (dp[j - 1] + dp[j]) % mod

print(dp[n])
