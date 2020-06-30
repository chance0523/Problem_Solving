# 1916번. 최소비용 구하기


import heapq
import sys
input = sys.stdin.readline


n = int(input())
m = int(input())
s = [[] for i in range(n+1)]
dist = [1e9 for i in range(n+1)]
for i in range(m):
    start, end, cost = map(int, input().split())
    s[start].append([end, cost])
# 구하고자 하는 출발, 도착 번호
start, end = map(int, input().split())


def dijkstra(start):
    dist[start] = 0
    heap = []
    heapq.heappush(heap, [dist[start], start])
    while heap:
        curDis, curNode = heapq.heappop(heap)
        if dist[curNode] < curDis:
            continue
        for a, w in s[curNode]:
            distance = curDis+w
            if distance < dist[a]:
                dist[a] = distance
                heapq.heappush(heap, [distance, a])
    return dist


dijkstra(start)
print(dist[end])
