# 9251번. LCS


import sys
input = sys.stdin.readline

a = list(input().rstrip())
b = list(input().rstrip())
dp = [[0 for i in range(len(a)+1)] for i in range(len(b)+1)]

for i in range(1, len(b)+1):
    for j in range(1, len(a)+1):
        if b[i-1] == a[j-1]:
            # 현재 위치의 값 = 왼쪽 대각선 값 + 1
            dp[i][j] = dp[i-1][j-1]+1
        else:
            # 현재 위치의 값 = max(왼쪽 값, 위쪽 값)
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

# 맨 마지막 dp가 최대
print(dp[-1][-1])
