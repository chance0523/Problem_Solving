import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int, input().split()))
    nList[-1] += 1

    for i in range(n-2, -1, -1):
        if nList[i] + 1 < nList[i + 1]:
            nList[i] += 1

    ans = len(set(nList))
    print(ans)
