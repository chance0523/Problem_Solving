from collections import deque

n, m = map(int,input().split())
nList = list(map(int,input().split()))

d = deque([i for i in range(1, n+1)])

cnt = 0
for num in nList:
    while True:
        if d[0] == num:
            d.popleft()
            break
        else:
            if d.index(num) < len(d) / 2:
                while d[0] != num:
                    d.append(d.popleft())
                    cnt += 1
            else:
                while d[0] != num:
                    d.appendleft(d.pop())
                    cnt += 1
print(cnt)