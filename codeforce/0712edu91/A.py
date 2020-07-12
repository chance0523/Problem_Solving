from itertools import combinations
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    pList = list(combinations(nList, 3))
    flag = False
    for p in pList:
        if p[0] < p[1]:
            if p[1] > p[2]:
                print('YES')
                print(nList.index(p[0])+1,
                      nList.index(p[1])+1, nList.index(p[2])+1)
                flag = True
                break
    if flag == False:
        print('NO')
