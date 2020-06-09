# 1002번. 터렛


t = int(input())

for i in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    dis = ((x1-x2)**2+(y1-y2)**2)**0.5  # 두 점 사이의 거리

    # 두 점이 같은 점이면
    if dis == 0:
        if r1 == r2:
            print(-1)
        else:
            print(0)
    else:
        # 외접, 내접
        if dis == r1+r2 or dis == abs(r1-r2):
            print(1)
        elif dis > r1+r2 or dis < abs(r1-r2):
            print(0)
        else:
            print(2)
