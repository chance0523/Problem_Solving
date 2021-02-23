a, b = map(int, input().split())
c = int(input())
h = c // 60
m = c % 60

a += h
a = a % 24

b += m
if b >= 60:
    b = b - 60
    a += 1
    if a >= 24:
        a = 0
b = b % 60

print(a, b)
