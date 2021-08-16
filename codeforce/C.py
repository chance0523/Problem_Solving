import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = [0] + list(map(int,input().rstrip().split()))
    box = [[False for _ in range(n+2)] for _ in range(n+2)]
    for i in range(1,n+1):
        box[i][i+1] = True
    for i in range(1, n+1):
        if nList[i] == 0:
            box[i][n+1] = True
        else:
            box[n+1][i] = True

    g = [[] for _ in range(n+2)]
    for i in range(1,n+2):
        for j in range(1,n+2):
            if box[i][j]:
                g[i].append(j)
    stack = [[i,0,[i]] for i in range(1,n+1)]
    print(stack)
    v = [False for i in range(n+2)]
    while stack:
        s = stack.pop()
        cur = s[0]
        cnt = s[1]
        track = s[2]
        if v[cur]:
            continue
        if cnt == n + 1:
            print(111)
            print(track)
            break
        v[cur] = True
        cnt += 1
        for i in range(len(g[cur])):
            if not v[g[cur][i]]:
                stack.append([g[cur][i], cnt, track + [g[cur][i]]])
                print(stack)

    print(g)
