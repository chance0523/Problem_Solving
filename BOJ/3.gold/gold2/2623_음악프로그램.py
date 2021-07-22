# 2623번. 음악프로그램


import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
inDegree = [0 for _ in range(n+1)]
graph = [[] for _ in range(n+1)]

for _ in range(m):
    iList = list(map(int, input().split()))
    for i in range(1, len(iList)-1):
        graph[iList[i]].append(iList[i+1])
        inDegree[iList[i+1]] += 1

queue = deque()
ans = []
for i in range(1, n + 1):
    if inDegree[i] == 0:
        queue.append(i)

while queue:
    now = queue.popleft()
    ans.append(now)
    for i in graph[now]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            queue.append(i)

if len(ans) != n:
    print(0)
else:
    for singer in ans:
        print(singer)