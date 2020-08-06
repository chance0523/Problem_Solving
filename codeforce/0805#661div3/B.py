import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    aList = list(map(int, input().split()))
    bList = list(map(int, input().split()))
    mina = min(aList)
    minb = min(bList)
    for i in range(n):
        aList[i] -= mina
    for i in range(n):
        bList[i] -= minb
    ans = 0

    for i in range(n):
        if aList[i] == 0:
            if bList[i] == 0:
                pass
            else:
                ans += bList[i]
        else:
            if bList[i] == 0:
                ans += aList[i]
            else:
                if aList[i] > bList[i]:
                    diff = aList[i]-bList[i]
                    ans += bList[i]
                    ans += diff
                else:
                    diff = bList[i]-aList[i]
                    ans += aList[i]
                    ans += diff

    print(ans)
