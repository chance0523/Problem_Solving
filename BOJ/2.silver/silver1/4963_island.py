# 4963. 섬의 개수

dx = [1, -1, 0, 0, 1, -1, 1, -1]  # 대각선 추가
dy = [0, 0, 1, -1, -1, -1, 1, 1]  # 대각선 추가


def graph(i, j):
    queue = [[i, j]]  # queue에 append 해줌
    while queue:
        a, b = queue[0][0], queue[0][1]
        del queue[0]  # popleft 해준 것과 같다.
        for k in range(8):  # 8방향 탐색
            x = a+dx[k]
            y = b+dy[k]
            # 범위 체크와 land인지 확인
            if 0 <= x < h and 0 <= y < w and matrix[x][y] == 1:
                matrix[x][y] = 0
                queue.append([x, y])


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    matrix = [[0 for _ in range(w)] for _ in range(h)]
    for i in range(h):
        matrix[i] = list(map(int, input().split()))
    cnt = 0
    for i in range(h):
        for j in range(w):
            if matrix[i][j] == 1:
                graph(i, j)
                cnt += 1
    print(cnt)
