import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    n = int(input())
    if n == 1:
        print(1)
    elif n % 2 == 1:
        print((n-1)//2)
    else:
        print(n//2)
