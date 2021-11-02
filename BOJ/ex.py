'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n = int(input())
mod = 1000000000

numbers = [2 ** i for i in range(25)]
dp = [0 for i in range(n + 1)]
dp[0] = 1

for num in numbers:
    if num <= n:
        for j in range(num, n+1):
            dp[j] += dp[j-num]

print(dp[n] % mod)
