# 11286번. 절댓값 힙


import heapq
import sys
input = sys.stdin.readline

n = int(input())
h = []
ans = []
for i in range(n):
    ii = int(input())
    if ii != 0:
        # heapq는 최소 힙.
        # 절댓값, 원본을 같이 넣어줌
        heapq.heappush(h, [abs(ii), ii])
    else:
        if not h:
            print(0)
        else:
            print((heapq.heappop(h))[1])
