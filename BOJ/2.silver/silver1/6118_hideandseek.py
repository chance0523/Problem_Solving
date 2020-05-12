# 6118번. 숨바꼭질

n, m = map(int, input().split(' '))
s = [[] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split(' '))
    s[a].append(b)
    s[b].append(a)

start = 1  # 시작 헛간
visited = [0]*(n+1)
visited[start] = 1

d = 0  # 거리
now = [start]

while True:
    nxt = []
    # nxt에 start로부터 거리가 같은 헛간을 넣어주고
    # visited에 check
    for i in now:
        for j in s[i]:
            if visited[j] == 1:
                continue
            else:
                nxt.append(j)
                visited[j] = 1
    if nxt:
        now = nxt
        d += 1
    else:
        print(min(now), d, len(now))
        break
