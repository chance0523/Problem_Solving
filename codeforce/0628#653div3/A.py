# A. Required Remainder


import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    x, y, n = map(int, input().split())
    # k % x = y
    num1 = n % x
    if num1 == y:
        k = n
    elif num1 > y:
        k = n-(num1-y)
    else:
        k = (n-num1)-x+y
    print(k)
