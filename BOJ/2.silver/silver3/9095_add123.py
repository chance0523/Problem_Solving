# 9095. 1,2,3 더하기
def add(n):
    memo = [0 for _ in range(11)]
    memo[1] = 1
    memo[2] = 2
    memo[3] = memo[2]+memo[1]+1

    if n <= 3:
        return memo[n]

    for i in range(4, n+1):
        memo[i] = memo[i-1]+memo[i-2]+memo[i-3]
    return memo[n]


T = int(input())
for _ in range(T):
    n = int(input())
    print(add(n))
