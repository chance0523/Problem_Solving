import sys
input = sys.stdin.readline


for _ in range(int(input())):
    a,b,c,m = map(int,input().split())
    if m == 0:
        print('YES')
        continue
    if a * b * c == 1:
        print('NO')
        continue