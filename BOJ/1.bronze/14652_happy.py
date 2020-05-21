# 14652_나는 행복합니다~


import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())

x = (k//m)
y = (k % m)
print(x, y)
