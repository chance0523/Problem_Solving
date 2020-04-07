# 2579. 계단 오르기
def calScore(n):
    for i in range(4, n+1):
        memo[i] = max(stair[i] + stair[i-1]+memo[i-3], stair[i] + memo[i-2])
    return memo[n]


n = int(input())
stair = [0 for _ in range(n+1)]
memo = [0 for _ in range(n+1)]
for i in range(1, n+1):
    stair[i] = int(input())

if n == 1:
    print(stair[1])
elif n == 2:
    print(stair[1]+stair[2])
elif n == 3:
    print(max(stair[3] + stair[1], stair[3] + stair[2]))


else:
    memo[1] = stair[1]
    memo[2] = stair[1]+stair[2]
    memo[3] = max(stair[3] + stair[1], stair[3] + stair[2])
    print(calScore(n))
