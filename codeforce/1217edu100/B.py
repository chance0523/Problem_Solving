import sys
input = sys.stdin.readline


def getNum(a):
    ret = 1
    while True:
        if ret > a:
            return ret // 2
        ret *= 2


for _ in range(int(input())):
    n = int(input())
    aList = list(map(int, input().split()))
    bList = []

    for i in range(n):
        bList.append(getNum(aList[i]))

    # s = 0
    # for i in range(n):
    #     s += 2 * abs(aList[i] - bList[i])
    # print('s ', sum(aList), s)
    print(*bList)
