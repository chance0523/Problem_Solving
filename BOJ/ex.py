n,m = map(int,input().split())
box = [[1e9 for _ in range(n+1)] for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            box[i][j] = 0

ans = [[0 for _ in range(n+1)] for _ in range(n+1)]
for i in range(m):
    a,b,c = map(int,input().split())
    box[a][b] = c
    box[b][a] = c
    ans[a][b] = b
    ans[b][a] = a

for t in range(n, 0, -1):
    for s in range(1, n+1):
        for e in range(1, n+1):
            if box[s][e] > box[s][t] + box[t][e]:
                box[s][e] = box[s][t] + box[t][e]
                ans[s][e] = ans[s][t]

s = ''
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            s += '- '
        else:
            s += str(ans[i][j]) + ' '
    s += '\n'
print(s.rstrip())