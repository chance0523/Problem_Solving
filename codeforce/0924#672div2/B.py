import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    ans = 0
    for i in range(40):
        cnt = 0
        for j in range(n):
            s = 1 << i
            s2 = 1 << (i+1)
            if nList[j] & s == s and s <= nList[j] < s2:
                cnt += 1
        if cnt > 1:
            ans += cnt*(cnt-1)//2
    print(ans)
