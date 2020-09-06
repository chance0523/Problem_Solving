# 11758번. CCW


# CCW 기본. 구글링 하면 많이 나온다.
x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())
x3, y3 = map(int, input().split())

num = (x1*y2 - x2*y1 + x2*y3 - x3*y2 + x3*y1 - x1*y3) / 2

if num > 0:
    print(1)
elif num < 0:
    print(-1)
else:
    print(0)
