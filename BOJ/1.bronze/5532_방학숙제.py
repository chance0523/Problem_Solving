# 5532번. 방학숙제


l = int(input())
a = int(input())
b = int(input())
c = int(input())
d = int(input())

if a % c == 0:
    korean = a // c
else:
    korean = a // c + 1
if b % d == 0:
    math = b // d
else:
    math = b // d + 1
print(l - max(korean, math))
