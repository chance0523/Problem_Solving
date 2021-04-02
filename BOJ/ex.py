for _ in range(int(input())):
    n = int(input())
    nList = list(map(int, input().split()))
    ans = 0

    while True:
        if not nList:
            break

        cur = nList.pop()

        l = len(nList)
        for i in range(l - 1, -1, -1):
            if cur >= nList[i]:
                ans += (cur - nList[i])
                nList.pop()
            else:
                break
    print(ans)
