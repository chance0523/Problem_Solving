# 13023번. ABCDE


import sys
input = sys.stdin.readline

n, m = map(int, input().split())
box = [[] for i in range(n)]
for i in range(m):
    a, b = map(int, input().split())
    box[a].append(b)
    box[b].append(a)

visited = [False for i in range(n)]


def dfs(index, cnt):
    global ans

    visited[index] = True

    if(cnt == 4):
        ans = True
        return

    for v in box[index]:
        if not visited[v]:
            dfs(v, cnt+1)
            visited[v] = False


ans = False
for i in range(n):
    dfs(i, 0)
    visited[i] = False
    if ans:
        break

print(1 if ans else 0)
