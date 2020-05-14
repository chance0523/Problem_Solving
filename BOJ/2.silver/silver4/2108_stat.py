# 2108번. 통계학

from collections import Counter
# 그나마 sys 써야 시간 초과 안남...
import sys
input = sys.stdin.readline


def mean(nList):
    return round(sum(nList)/n)


def median(nList):
    if n == 1:
        return nList[0]
    else:
        # n==홀수
        return nList[n//2]


def mode(nList):
    if n == 1:
        return nList[0]
    else:
        c = Counter(nList).most_common(2)
        if c[0][1] == c[1][1]:
            return c[1][0]
        else:
            return c[0][0]


def mM(nList):
    return (nList[-1]-nList[0])


n = int(input())
nList = sorted([int(input()) for _ in range(n)])

print(mean(nList))
print(median(nList))
print(mode(nList))
print(mM(nList))
