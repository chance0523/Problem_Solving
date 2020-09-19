# 10158번. 개미


import sys
input = sys.stdin.readline

w, h = map(int, input().split())
p, q = map(int, input().split())
t = int(input())

# 개미는 오른쪽 위 45도 방향으로 먼저 움직임
garo = (p+t)//w
sero = (q+t)//h

# garo=0 이면 오른쪽으로 가는 중, 1이면 왼쪽으로 가는중 ...
r = (p+t) % w
if garo % 2 == 1:
    r = w-r
c = (q+t) % h
if sero % 2 == 1:
    c = h-c
print(r, c)
