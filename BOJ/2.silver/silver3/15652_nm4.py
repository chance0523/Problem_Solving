# 15652번. N과 M (4)


from itertools import combinations_with_replacement
n, m = map(int, input().split())
nList = [i for i in range(1, n+1)]

cList = list(combinations_with_replacement(nList, m))

for c in cList:
    for i in c:
        print(i, end=' ')
    print(end='\n')
