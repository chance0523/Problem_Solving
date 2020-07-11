# 15649번. N과 M (1)


from itertools import permutations
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nList = [i for i in range(1, n+1)]
cList = list(permutations(nList, m))

for c in cList:
    print(*c)
