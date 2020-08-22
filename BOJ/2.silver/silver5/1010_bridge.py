# 1010번. 다리놓기


s = [[0 for i in range(30)] for i in range(30)]
for i in range(1, 30):
    s[1][i] = i
for i in range(2, 30):
    for j in range(i, 30):
        for k in range(i-1, j):
            s[i][j] += s[i-1][k]
for i in range(int(input())):
    n, m = map(int, input().split())
    print(s[n][m])
