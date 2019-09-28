m, n = map(int, input().split())

box = [[0]*m for _ in range(n)]

for i in range(n):
    box[i] = list(map(int, input().split()))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

unriped = 0
tomato = []

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            tomato.append((i, j))
        elif box[i][j] == 0:
            unriped += 1

days = 1

while tomato:

    t = tomato.pop(0)

    x, y = t[0], t[1]

    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]

        if nx < n and nx >= 0 and ny < m and ny >= 0:
            if box[nx][ny] == 0:
                box[nx][ny] = box[x][y]+1
                tomato.append((nx, ny))
                days = max(box[nx][ny], days)
                unriped -= 1


if unriped == 0:
    print(days-1)
else:
    print(-1)
