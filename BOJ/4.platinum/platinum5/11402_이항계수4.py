# 11402번. 이항 계수 4


# 루카스 정리
# https://bowbowbow.tistory.com/2


import sys
sys.setrecursionlimit(5000)  # 안 써주면 터진다


def binomial(n, k, p):
    if cache[n][k] != 0:
        return cache[n][k]

    if k == 0 or n == k:
        cache[n][k] = 1
        return cache[n][k]

    cache[n][k] = (binomial(n-1, k-1, p) + binomial(n-1, k, p) % p)
    return cache[n][k]


def get_digits(n, b):  # b진법 전개식으로 나타내기
    d = []
    while n:
        d.append(n % b)
        n //= b
    return d


def lucas_theorem(n, k, p):
    ret = 1
    nd = get_digits(n, p)
    kd = get_digits(k, p)

    for i in range(max(len(nd), len(kd))):
        nn, kk = 0, 0
        if i < len(nd):
            nn = nd[i]
        else:
            nn = 0

        if i < len(kd):
            kk = kd[i]
        else:
            kk = 0

        if nn < kk:  # 0으로 취급
            return 0

        ret = (ret * binomial(nn, kk, p) % p)  # 계산

    return ret


n, k, m = map(int, input().split())
cache = [[0 for _ in range(2010)] for _ in range(2010)]

print(lucas_theorem(n, k, m))


"""
# 다른 풀이
from math import factorial


def nCr(n, r):
    if r > n:
        return 0
    else:
        return factorial(n)//factorial(r)//factorial(n-r)  # nCr


n, k, m = map(int, input().split())
ans = 1
while n > 0:
    ans = ans*nCr(n % m, k % m) % m
    n //= m
    k //= m
print(ans)

"""
