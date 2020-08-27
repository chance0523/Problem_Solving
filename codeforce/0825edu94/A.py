import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    s = list(input().rstrip())
    nList = [0 for i in range(n)]
    for i in range(n):
        num = 1
        for j in range(i, i+n):
            num = num & int(s[j])
        nList[i] = num

    ans = ""
    for i in range(n):
        ans += str(nList[i])
    print(ans)
