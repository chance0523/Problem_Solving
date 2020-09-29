import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    for i in range(n-1):
        if nList[i] <= nList[i+1]:
            ans = 'YES'
            break
        ans = 'NO'
    print(ans)
