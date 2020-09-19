import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int, input().split()))
    for i in range(n-1):
        if nList[i] > 0:
            nList[i+1] += nList[i]
            nList[i] = 0
    ans = 0
    for i in nList:
        if i < 0:
            ans += -i
    print(ans)
