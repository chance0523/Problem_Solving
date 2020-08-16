import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    if nList[0]+nList[1] > nList[-1]:
        print(-1)
    else:
        print(1, 2, n)
