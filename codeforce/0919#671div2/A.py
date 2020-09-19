import sys
input = sys.stdin.readline


t = int(input())

for _ in range(t):
    n = int(input())
    nList = list(map(int, input().rstrip()))
    # print(nList)
    # raze : odd
    # breach : even
    flag = True
    if n % 2 == 0:
        for i in range(n):
            if i % 2 == 1 and nList[i] % 2 == 0:
                flag = False
                break
        if flag:
            print(1)
        else:
            print(2)
    else:
        for i in range(n):
            if i % 2 == 0 and nList[i] % 2 == 1:
                flag = False
                break
        if flag:
            print(2)
        else:
            print(1)
