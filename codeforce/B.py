import sys
input = sys.stdin.readline
from collections import deque

for _ in range(int(input())):
    n = int(input())
    nList = list(map(int,input().rstrip().split()))
    d = deque([nList[0]])
    for i in range(1, n):
        if nList[i] < d[0]:
            d.appendleft(nList[i])
        else:
            d.append(nList[i])
    print(*d)