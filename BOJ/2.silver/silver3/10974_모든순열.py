# 10974번. 모든 순열


from itertools import permutations
n = int(input())
nList = [i for i in range(1, n + 1)]
pList = list(permutations(nList,n))
for p in  pList:
    print(*p)