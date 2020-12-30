import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int, input().split()))
    m = int(input())
    mList = list(map(int, input().split()))

    maxN = 0
    cnt = 0
    for i in range(n):
        cnt += nList[i]
        maxN = max(maxN, cnt)

    maxM = 0
    cnt = 0
    for i in range(m):
        cnt += mList[i]
        maxM = max(maxM, cnt)

    print(maxN+maxM)
