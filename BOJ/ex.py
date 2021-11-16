'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n = int(input())
nList = list(map(int,input().rstrip().split()))
dp = [0 for _ in range(n)]
for i in range(1, n):
    for k in range(1, i+2):
        temp = nList[i-k+1:i+1]
        if k == i+1:
            k = i
        dp[i] = max(dp[i], dp[i-k] + abs(max(temp)-min(temp)))
print(dp[-1])