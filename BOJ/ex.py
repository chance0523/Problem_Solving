while True:
    n,m = map(int,input().split())
    if n+m==0:
        break
    nList = [[0,i] for i in range(10001)]
    for i in range(n):
        kList = list(map(int,input().split()))
        for k in kList:
            nList[k][0] += 1
    nList.sort(reverse=True)
    M = nList[0][0]
    M2 = 0
    for i in range(len(nList)):
        if nList[i][0] == M: # 1등
            continue
        else:
            M2 = nList[i][0]
            break
    ans = []
    for i in range(len(nList)):
        if nList[i][0] == M2:
            ans.append(nList[i][1])
    ans.sort()
    print(*ans)