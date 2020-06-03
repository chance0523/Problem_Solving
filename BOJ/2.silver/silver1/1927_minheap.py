# 1927번. 최소 힙


import heapq
import sys
input = sys.stdin.readline

n = int(input())
h = []
for i in range(n):
    ii = int(input())
    if ii != 0:
        heapq.heappush(h, ii)
    else:
        if not h:
            print(0)
        else:
            print(heapq.heappop(h))
