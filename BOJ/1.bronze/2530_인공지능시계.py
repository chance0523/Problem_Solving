# 2530번. 인공지능 시계


a, b, c = map(int, input().split())
d = int(input())
time = a * 3600 + b * 60 + c
time += d
a = time // 3600
if a >= 24:
    a %= 24
b = time % 3600 // 60
c = time % 3600 % 60
print(a, b, c)
