# 21937번. 작업


import sys
input = sys.stdin.readline


n,m = map(int,input().rstrip().split())
box = [[] for i in range(n+1)]
v = [False for _ in range(n+1)]

for i in range(m):
    a,b = map(int,input().rstrip().split())
    box[b].append(a)
x = int(input())

s = [x]
v[x] = True
ans = 0
while s:
    cur_x = s.pop()
    for a in box[cur_x]:
        if not v[a]:
            s.append(a)
            v[a] = True
            ans += 1

print(ans)

