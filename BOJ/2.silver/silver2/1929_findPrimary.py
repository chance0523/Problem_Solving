# 1929번. 소수 구하기

import sys
input = sys.stdin.readline

m, n = map(int, input().split())
max = 1000000


# 에라스토테네스의 체
def etc(max):
    pList = [True]*max
    mnum = int(max**0.5)
    for i in range(2, mnum+1):
        if pList[i]:
            for j in range(i+i, max, i):
                pList[j] = False
        else:
            continue
    return [i for i in range(2, max) if pList[i]]


pList = etc(max)
for p in pList:
    if p >= m and p <= n:
        print(p)
