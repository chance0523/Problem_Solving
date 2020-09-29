import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    s = list(map(int, input().rstrip()))
    if n == 1:
        print(-1)
        continue
    su = sum(s)
    if s[-1] % 2 == 1:
        ans = False
        for i in range(n-1):
            if s[i] % 2 == 1:
                ans = True
                break
        if ans:
            print(str(s[i])+str(s[-1]))
        else:
            print(-1)
    else:
        ans = []
        for i in range(n-1):
            if s[i] % 2 == 1:
                ans.append(s[i])
        if len(ans) >= 2:
            print(str(ans[0])+str(ans[1]))
        else:
            print(-1)
