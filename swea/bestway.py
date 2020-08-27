ans = 1e9


def perm(nList, cnt, n):
    global ans
    if cnt == n:
        d = 0
        d += abs(c[0]-cos[nList[0]][0]) + abs(c[1]-cos[nList[0]][1])
        for i in range(n-1):
            d += (abs(cos[nList[i]][0]-cos[nList[i+1]][0]) +
                  abs(cos[nList[i]][1]-cos[nList[i+1]][1]))
            if(d > ans):
                return
        d += abs(h[0]-cos[nList[n-1]][0]) + abs(h[1]-cos[nList[n-1]][1])

        ans = min(ans, d)

    for i in range(cnt, n):
        nList[i], nList[cnt] = nList[cnt], nList[i]
        perm(nList, cnt+1, n)
        nList[i], nList[cnt] = nList[cnt], nList[i]


for tt in range(int(input())):
    # 입력
    n = int(input())
    tmap = list(map(int, input().split()))
    c = [tmap[0], tmap[1]]
    h = [tmap[2], tmap[3]]
    cos = [[0, 0] for i in range(n)]
    j = 0
    for i in range(4, len(tmap)-1, 2):
        cos[j][0] = tmap[i]
        cos[j][1] = tmap[i+1]
        j += 1

    nList = [i for i in range(n)]
    perm(nList, 0, n)
    print('#',end='')
    print(tt+1,ans)
