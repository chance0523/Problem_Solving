# 15663번. N과 M (9)


from itertools import permutations
n, m = map(int, input().split())
nList = list(map(int, input().split()))
# nList.sort()
cList = list(set(permutations(nList, m)))
cList.sort()
for c in cList:
    for i in c:
        print(i, end=' ')
    print()
