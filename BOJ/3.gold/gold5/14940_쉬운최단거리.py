# 14940번. 쉬운 최단거리


from collections import deque
import sys

n, m = map(int, input().rstrip().split())
box = [0 for _ in range(n)]
tr, tc = 0, 0  # 목표지점
for i in range(n):
    box[i] = list(map(int, input().rstrip().split()))
    for j in range(len(box[i])):
        if box[i][j] == 2:
            tr, tc = i, j

ans = [[-1 for _ in range(m)] for _ in range(n)]
for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            ans[i][j] = 0

v = [[False for _ in range(m)] for _ in range(n)]

q = deque([[tr, tc, 0]])
ans[tr][tc] = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

while q:
    t = q.popleft()
    cr, cc, cnt = t[0], t[1], t[2]
    if v[cr][cc]:
        continue
    v[cr][cc] = True
    for d in range(4):
        nr = cr + dx[d]
        nc = cc + dy[d]
        if 0 <= nr < n and 0 <= nc < m and not v[nr][nc]:
            if box[nr][nc] == 1:
                ans[nr][nc] = cnt + 1
                q.append([nr, nc, cnt + 1])

for i in range(n):
    print(*ans[i])
