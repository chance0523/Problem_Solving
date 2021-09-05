# 1068번. 트리


n = int(input())
nList = list(map(int,input().split()))
delete = int(input())
tree = [[] for i in range(n)]

for i in range(n):
    if nList[i] == -1:
        start = i
        continue
    if i == delete:
        continue
    tree[nList[i]].append(i)

ans = 0
if start == delete:
    print(0)
else:
    s = []
    s.append(start)
    while s:
        cur = s.pop()
        if not tree[cur]:
            ans += 1
        else:
            for t in tree[cur]:
                s.append(t)
    print(ans)