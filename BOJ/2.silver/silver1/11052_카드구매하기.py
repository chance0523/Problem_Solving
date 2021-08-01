# 11052번. 카드 구매하기


n = int(input())
pList = [0] + list(map(int,input().split()))
dp = [0 for _ in range(n+1)]
dp[1] = pList[1]
for i in range(2, n+1):
    for j in range(1, i+1):
        dp[i] = max(dp[i], dp[i-j] + pList[j])
print(dp[n])
