import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    cList = list(input().rstrip())
    ans = ''
    for i in range(n):
        if cList[i] == 'L' or cList[i] == 'R':
            ans += cList[i]
        elif cList[i] == 'U':
            ans += 'D'
        else:
            ans += 'U'
    print(ans)