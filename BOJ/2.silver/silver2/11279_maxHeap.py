# 11279번. 최대 힙


import heapq
import sys
input = sys.stdin.readline

n = int(input())
h = []
for i in range(n):
    ii = int(input())
    if ii != 0:
        # heapq는 최소 힙.
        # 최대 힙으로 바꾸기 위해 input을 음수로 바꿔줌
        heapq.heappush(h, (-ii))
    else:
        if not h:
            print(0)
        else:
            print(-1 * heapq.heappop(h))
