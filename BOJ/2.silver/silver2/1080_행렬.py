# 1080번. 행렬


import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = [list(map(int, input().rstrip())) for _ in range(n)]
b = [list(map(int, input().rstrip())) for _ in range(n)]


def isEqual():
    for i in range(n):
        for j in range(m):
            if a[i][j] != b[i][j]:
                return False
    return True


ans = 0
for i in range(n - 2):
    for j in range(m - 2):
        if a[i][j] != b[i][j]:  # 다르다면
            # 1->0, 0->1
            for x in range(i, i + 3):
                for y in range(j, j + 3):
                    a[x][y] = 1 - a[x][y]
            ans += 1

if isEqual():
    print(ans)
else:
    print(-1)
