# 15666번. N과 M (12)


from itertools import combinations_with_replacement
n, m = map(int, input().split())
nList = list(map(int, input().split()))
nList.sort()
cList = list(set(combinations_with_replacement(nList, m)))
cList.sort()

for c in cList:
    for i in c:
        print(i, end=' ')
    print()
