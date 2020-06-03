# 1697번. 숨바꼭질


from collections import deque
import sys
input = sys.stdin.readline


def bfs(v):
    cnt = 0
    q = deque([[v, cnt]])
    while q:
        v = q.popleft()
        vv = v[0]
        cnt = v[1]
        if not visited[vv]:
            visited[vv] = True
            if vv == k:
                return cnt
            cnt += 1
            if vv*2 <= 100000:
                q.append([vv*2, cnt])
            if vv+1 <= 100000:
                q.append([vv+1, cnt])
            if vv-1 >= 0:
                q.append([vv-1, cnt])
    return cnt


# n, k = 5, 17
n, k = map(int, input().split())

visited = [False]*100001
print(bfs(n))
