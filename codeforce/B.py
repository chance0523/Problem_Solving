import sys
input = sys.stdin.readline

for _ in range(int(input())):
    a,b = map(int,input().split())
    l = a
    n = 0
    if (a-1) % 4 == 0:
        n = a-1
    elif (a-1) % 4 == 1:
        n = 1
    elif (a-1) % 4 == 2:
        n = a
    elif (a-1) % 4 == 3:
        n = 0
    c = n ^ b
    if n == b:
        print(l)
        continue
    if c != a:
        print(l+1)
    else:
        print(l+2)