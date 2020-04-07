# 11726. 2xn 타일링
def tiling(n):
    memo[1] = 1
    memo[2] = 2
    if n <= 2:
        return memo[n]
    for i in range(3, n+1):
        memo[i] = memo[i-1]+memo[i-2]
    return memo[n]


n = int(input())
memo = [0 for _ in range(1001)]
print(tiling(n) % 10007)
