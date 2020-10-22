# 2293번. 동전1


import sys
input = sys.stdin.readline

n, k = map(int, input().split())
nList = [int(input()) for i in range(n)]
dp = [0 for i in range(k+1)]

dp[0] = 1  # 한 종류의 동전만을 사용했을 때 더하기 위한 수

for i in nList:  # 1, 2, 5 하나씩 뽑아서
    for j in range(i, k+1):  # dp 배열 채우기
        dp[j] += dp[j-i]  # 이 동전으로 만들 수 있는 (가방 문제)
print(dp[k])
