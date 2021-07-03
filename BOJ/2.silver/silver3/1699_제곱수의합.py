# 1699번. 제곱수의 합


n = int(input())
dp = [i for i in range(n+1)]
for i in range(1, n+1):
    for j in range(1, i):
        if j**2 > i:
            break
        dp[i] = min(dp[i],dp[i-j**2]+1)
print(dp[n])