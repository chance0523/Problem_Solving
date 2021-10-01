import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n,m,k = map(int,input().split())
    de = int(n*(n-3)//2)
    if n == 1:
        print('YES')
        continue
    if k == 1:
        print('NO')
        continue
    if k == 2:
        if n <= 3 and m >= 3:
            print('YES')
        else:
            print('NO')
    if k == 3:
        if de <= m - n:
            print('YES')
        else:
            print('NO')
        