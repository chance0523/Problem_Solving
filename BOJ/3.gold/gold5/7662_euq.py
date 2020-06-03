# 7662번. 이중 우선순위 큐


import heapq
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    minh = []
    maxh = []
    visited = [False]*1000001
    for i in range(k):
        s, n = input().split()
        n = int(n)
        if s == 'I':
            heapq.heappush(minh, (n, i))
            heapq.heappush(maxh, (-n, i))
        elif s == 'D':
            if not minh:
                continue
            else:
                if n == -1:  # 최솟값 out
                    while True:
                        if not visited[minh[0][1]]:
                            visited[minh[0][1]] = True
                            mi = heapq.heappop(minh)
                            break
                        else:
                            minh.pop(0)
                            continue
                else:
                    while True:
                        print(maxh)
                        if not visited[maxh[0][1]]:
                            visited[minh[0][1]] = True
                            ma = heapq.heappop(maxh)
                            break
                        else:
                            maxh.pop(0)
                            continue

    if not minh:
        print('EMPTY')
    else:
        print(-1*heapq.heappop(maxh), heapq.heappop(minh))
