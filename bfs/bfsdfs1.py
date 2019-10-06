from collections import deque
n, m, v = map(int, input().split())
mat = [[0]*(n+1)for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    mat[a][b] = mat[b][a] = 1


def dfs(n, m, v):
    visited = [0]*(n+1)
    #visited[v] = 1
    q = deque()
    q.append(v)
    t = deque()

    while q:
        cn=q.pop()
        if visited[cn]:
            continue
        else:
            visited[cn]=1
            t.append(cn)
            for b in range(n,0,-1):
                if mat[cn][b] and not visited[b]:
                    q.append(b)

    while t:
        print(t.popleft(),end=' ')


def bfs(n, m, v):
    visited = [0]*(n+1)
    visited[v] = 1
    q = deque()
    q.append(v)
    t = deque()

    while q:
        cn = q.popleft()
        t.append(cn)
        for b in range(1, n+1):
            if mat[cn][b] and not visited[b]:
                visited[b] = 1
                q.append(b)

    while t:
        print(t.popleft(),end=' ')


dfs(n, m, v)
print("")
bfs(n, m, v)
