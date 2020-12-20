import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    rList = list(input().rstrip())
    bList = list(input().rstrip())
    r = 0
    b = 0
    e = 0
    for i in range(n):
        if rList[i] > bList[i]:
            r += 1
        elif rList[i] < bList[i]:
            b += 1
        else:
            e += 1

    if r > b:
        print('RED')
    elif r < b:
        print('BLUE')
    else:
        print('EQUAL')
