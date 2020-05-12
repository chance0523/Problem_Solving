import sys
import collections

input = sys.stdin.readline

M, N = map(int, input().split())

unriped = 0

farm = []
tomato = collections.deque([])

for i in range(N):

    farm.append(list(map(int, input().split())))

    for t in range(M):
        if farm[i][t] == 1:
            tomato.append((i, t))
        elif farm[i][t] == 0:
            unriped += 1

days = 1

while tomato:

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    t = tomato.popleft()

    x = t[0]
    y = t[1]

    for i in range(4):

        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= N or nx < 0 or ny >= M or ny < 0:
            continue
        if farm[nx][ny] != 0:
            continue

        farm[nx][ny] = farm[x][y] + 1
        tomato.append((nx, ny))
        days = max(farm[nx][ny], days)
        unriped -= 1

if unriped == 0:
    print(days-1)
else:
    print(-1)
