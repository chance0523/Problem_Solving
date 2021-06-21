# 5928번. Contest Timing


d, h, m = map(int, input().split())

time1 = d * 24 * 60 + h * 60 + m
time2 = 11 * 24 * 60 + 11 * 60 + 11

diff = time1 - time2

if time2 > time1:
    print(-1)
else:
    print(diff)