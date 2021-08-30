import sys
input = sys.stdin.readline

for _ in range(int(input())):
    c,d = map(int,input().rstrip().split())
    if c == d:
        if c==0:
            ans = 0
        else:
            ans = 1
    elif (c+d)%2==0:
        ans = 2
    else:
        ans = -1
    print(ans)