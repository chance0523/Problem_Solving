import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n,k = map(int,input().split())
    kList = list(map(int,input().rstrip().split()))
    for i in range(k):
        kList[i] = n - kList[i]
    kList.sort()
    ans = 0
    s = 0
    for i in range(k):
        if s + kList[i] >= n:
            print(ans)
            break
        s += kList[i]
        ans += 1
   