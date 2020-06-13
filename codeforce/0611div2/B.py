import sys
input = sys.stdin.readline


t = int(input())
for i in range(t):
    n, x, m = map(int, input().split())
    nList = [0 for k in range(n+1)]
    nList[x] = 1
    for j in range(m):
        l, r = map(int, input().split())
