n = int(input())
M = 0
Midx = 0
for i in range(1, n+1):
    nList = list(map(int,input().split()))
    tM = 0
    for a in range(3):
        for b in range(a+1, 4):
            for c in range(b+1, 5):
                s = nList[a] + nList[b] + nList[c]
                tM = max(tM, s%10)
    if tM >= M:
        M = tM
        Midx = i
print(Midx)