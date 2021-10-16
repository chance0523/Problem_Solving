import sys
input = sys.stdin.readline

for _ in range(int(input())):
    nList = list(input().rstrip())
    nList = nList[::-1]
    # 00 25 50 75
    ans = len(nList)
    for i in range(len(nList)-1):
        for j in range(i+1, len(nList)):
            cur = nList[i] + nList[j]
            if cur in ['00','52','05','57']:
                ans = min(ans, i+(j-i-1))

    print(ans)
