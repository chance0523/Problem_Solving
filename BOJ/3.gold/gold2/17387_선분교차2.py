# 17387번. 선분 교차 2


# https://imucoding.tistory.com/1060
import sys

x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

a = [x1, y1]
b = [x2, y2]
c = [x3, y3]
d = [x4, y4]


def ccw(a, b, c):
    tmp = (b[0] - a[0]) * (c[1] - a[1]) - (c[0] - a[0]) * (b[1] - a[1])
    if tmp > 0:  # 반시계
        return 1
    elif tmp == 0:  # 일직선
        return 0
    else:  # 시계
        return -1


abc = ccw(a, b, c)
abd = ccw(a, b, d)
cda = ccw(c, d, a)
cdb = ccw(c, d, b)
if abc * abd == 0 and cda * cdb == 0:
    if a > b:
        a, b = b, a
    if c > d:
        c, d = d, c
    if a <= d and c <= b:
        print(1)
    else:
        print(0)
    sys.exit()
if abc * abd <= 0 and cda * cdb <= 0:
    print(1)
else:
    print(0)