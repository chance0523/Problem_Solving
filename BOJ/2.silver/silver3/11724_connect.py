# 11724번. 연결 요소의 개수


import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = 0
visited = [0]*(n+1)


def dfs(start):
    global visited
    stack = [start]
    while stack:
        a = stack.pop()
        if not visited[a]:
            visited[a] = 1
            for i in graph[a]:
                if not visited[i]:
                    stack.append(i)


for i in range(1, n+1):
    if not visited[i]:
        cnt += 1
        dfs(i)
print(cnt)
