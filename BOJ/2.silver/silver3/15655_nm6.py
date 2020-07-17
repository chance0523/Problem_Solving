# 15655번. N과 M (6)


from itertools import combinations
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nList = list(map(int, input().split()))
nList.sort()
cList = list(combinations(nList, m))

for c in cList:
    print(*c)
