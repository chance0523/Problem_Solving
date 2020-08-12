import sys
input = sys.stdin.readline


n, m, sx, sy = map(int, input().split())
# rook
v = [[0 for i in range(m+1)] for i in range(n+1)]


def func(sx, sy):
    ny = sy
    for i in range(1, m+1):
        if v[sx][i] == 0:
            v[sx][i] = 1
            print(sx, i)
            ny = i  # last point
    if sx != n:
        if v[sx+1][ny] == 0:
            v[sx+1][ny] = 1
            print(sx+1, ny)
            func(sx+1, ny)
        elif v[sx+1][ny] == 1:
            v[sx+2][ny] = 1
            print(sx+2, ny)
            func(sx+2, ny)

            v[sx+1][m] = 1
            print(sx+1, m)
            for i in range(1, m+1):
                if v[sx+1][i] == 0:
                    v[sx+1][i] = 1
                    print(sx+1, i)
    else:
        return


v[sx][sy] = 1
print(sx, sy)  # init

sy = 1
v[sx][sy] = 1
print(sx, sy)

sx = 1
v[sx][sy] = 1
print(sx, sy)
func(sx, sy)
