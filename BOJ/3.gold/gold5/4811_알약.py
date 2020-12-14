# 4811번. 알약


import sys
input = sys.stdin.readline
sys.setrecursionlimit(50000)


def dfs(w, h):
    if dp[w][h]:
        return dp[w][h]

    if w == 0:  # 한 조각짜리가 없으면 무조건 반조각 짜리를 꺼내야
        return 1

    dp[w][h] = dfs(w - 1, h + 1)

    if h > 0:
        dp[w][h] += dfs(w, h - 1)  # 이런 경우도 더해주기

    return dp[w][h]


dp = [[0 for i in range(31)] for i in range(31)]

while True:
    n = int(input())

    if n == 0:
        break
    print(dfs(n, 0))  # 처음에는 완전한 n개의 알약이 있음
