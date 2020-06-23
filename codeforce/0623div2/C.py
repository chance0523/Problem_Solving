import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n, k = map(int, input().split())
    nList = list(map(int, input().split()))
    wList = list(map(int, input().split()))
    nList.sort()
    nList2 = nList[:]
    # print(nList)
    ans = [[] for _ in range(k)]
    while nList:
        for i in range(k):
            if len(ans[i]) != wList[i]:
                ans[i].append(nList.pop())

    happy1 = 0
    for i in range(k):
        happy1 += (ans[i][0]+ans[i][-1])

    ans = [[] for _ in range(k)]
    while nList2:
        for i in range(k):
            for j in range(wList[i]):
                ans[i].append(nList2.pop())

    happy2 = 0
    for i in range(k):
        happy2 += (ans[i][0]+ans[i][-1])

    print(max(happy1, happy2))
