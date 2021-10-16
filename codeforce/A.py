import sys
input = sys.stdin.readline

for _ in range(int(input())):
    a,b,c = map(int,input().split())
    M = max(a,b,c)
    if M == a:
        a1 = 0
    else:
        a1 = M - a  + 1
    if M == b:
        b1 = 0
    else:
        b1 = M - b  + 1
    if M == c:
        c1 = 0
    else:
        c1 = M - c  + 1
    if a==b==M:
        a1 = 1
        b1 = 1
    if b==c==M:
        b1 = 1
        c1 = 1
    if c == a==M:
        a1 = 1
        c1= 1
    print(a1,b1,c1)