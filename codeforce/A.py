import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    s = n // 6
    m = n // 8
    l = n // 10
    aList = [[s*15,s*6],[m*20,m*8],[l*25,l*10]]
    aList.sort(reverse=True)
    n -= aList[0][1]
    ans = aList[0][0]
    print(aList,n,ans)
    if 1<n<=6:
        ans += 15
    elif 6<n<=8:
        ans += 20
    elif 8<n:
        ans+=25