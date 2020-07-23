# 18291번. 비요뜨의 징검다리 건너기


for _ in range(int(input())):
    n = int(input())
    x = 2  # 2의 제곱
    n -= 2  # 2의 n-2제곱으로 풀어야함
    mod = 10**9+7
    ans = 1
    # 고속 거듭제곱
    if n < 0:
        print(1)
    else:
        while n:
            if n & 1:
                ans *= x
                ans %= mod
            n //= 2
            x *= x
            x %= mod
        print(ans)
