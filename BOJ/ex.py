'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n, k = map(int,input().split())
kList = [int(input()) for _ in range(n)]
dp = [0 for _ in range(k + 1)]
for i in range(1, k+1):
    temp = []
    for j in kList:
        if j <= i and dp[i-j] != -1:
            temp.append(dp[i-j])
    if not temp:
        dp[i] = -1
    else:
        dp[i] = min(temp) +1
print(dp[k])