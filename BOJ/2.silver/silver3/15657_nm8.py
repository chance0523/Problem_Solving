# 15657번. N과 M (8)


from itertools import combinations_with_replacement
n, m = map(int, input().split())
nList = list(map(int, input().split()))
nList.sort()
cList = list(combinations_with_replacement(nList, m))

for c in cList:
    for i in c:
        print(i, end=' ')
    print()
