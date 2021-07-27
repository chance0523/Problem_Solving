# 1247번. 부호


import sys
input = sys.stdin.readline

for _ in range(3):
    n = int(input())
    s = 0
    for i in range(n):
        s += int(input())
    if s > 0:
        print('+')
    elif s == 0:
        print(0)
    else:
        print('-')