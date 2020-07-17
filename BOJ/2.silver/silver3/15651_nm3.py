# 15651번. N과 M (3)


from itertools import product
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nList = [i for i in range(1, n+1)]
# 중복순열로 쉽게 구현
cList = list(product(nList, repeat=m))

for c in cList:
    print(*c)
