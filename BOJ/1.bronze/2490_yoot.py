# 2490번. 윷놀이


def yoot(y):
    # 윷 = 0 4개, 모 = 1 4개
    bae = 0
    dng = 0
    for a in y:
        if a == 0:
            bae += 1
        else:
            dng += 1
    if bae == 1:
        return 'A'
    elif bae == 2:
        return 'B'
    elif bae == 3:
        return 'C'
    elif bae == 4:
        return 'D'
    else:
        return 'E'


y1 = list(map(int, input().split()))
y2 = list(map(int, input().split()))
y3 = list(map(int, input().split()))

print(yoot(y1))
print(yoot(y2))
print(yoot(y3))
