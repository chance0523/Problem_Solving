# 18352번. 특정 거리의 도시 찾기


import sys
from heapq import heappush, heappop
input = sys.stdin.readline
INF = sys.maxsize

n,m,k,x = map(int,input().split())
box = [[] for _ in range(n+1)]
dist = [INF] * (n+1)
heap = []

for i in range(m):
    a,b = map(int,input().split())
    box[a].append([b, 1])

def dij(start):
    heappush(heap, [0, start])
    dist[start] = 0
    while heap:
        w, n = heappop(heap)
        for n_n, weight in box[n]:
            n_w = weight + w
            if n_w < dist[n_n]:
                dist[n_n] = n_w
                heappush(heap, [n_w, n_n])
ans = []
dij(x)
for i in range(1, n+1):
    if dist[i] == k:
        ans.append(i)
if ans:
    for a in ans:
        print(a)
else:
    print(-1)

        