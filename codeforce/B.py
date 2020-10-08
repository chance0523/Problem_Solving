import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n, k = map(int, input().split())
    nList = list(map(int, input().rstrip().split()))
    ans = 0
    l = len(set(nList))
    if k == 1:
        if l != 1:
            print(-1)
        if l == 1:
            print(1)
    else:
        ans = 1
        l = l-k
        if l <= 0:
            print(ans)
            continue
        while True:
            l = l-(k-1)
            ans += 1
            if l <= 0:
                print(ans)
                break
