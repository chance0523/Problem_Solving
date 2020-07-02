# A. Magical Sticks


import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    if n == 1:
        print(1)
    elif n == 2:
        print(1)
    elif n == 3:
        print(2)
    else:
        if n % 2 == 0:
            print(n//2)
        else:
            n -= 1
            print((n//2)+1)
