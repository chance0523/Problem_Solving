import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int,input().rstrip().split()))
    cnt = 0
    ans = 0
    for i in range(n):
        if nList[i]%2==0:
            ans = 0
            cnt += 1
    if cnt == n or cnt == 0:
        ans = min(nList)
    print(ans)
