# 7568번. 덩치

N = int(input())
w = [0 for i in range(N)]
h = [0 for i in range(N)]
rank = [1 for i in range(N)]

for i in range(N):
    w[i], h[i] = map(int, input().split())

for i in range(N):
    for j in range(N):
        if w[i] < w[j] and h[i] < h[j]:
            rank[i] += 1

for i in range(N):
    print(rank[i], end=' ')
