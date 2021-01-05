import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int, input().split()))
    a = nList.count(1)
    b = nList.count(2)
    s = sum(nList)
    if s % 2:
        print('NO')
        continue
    t = s // 2

    if a == 0:
        if b % 2:
            print('NO')
        else:
            print('YES')
        continue
    if b == 0:
        if a % 2:
            print('NO')
        else:
            print('YES')
        continue

    flag = False
    for i in range(a+1):
        if flag:
            break
        for j in range(b+1):
            if i + 2 * j == t:
                flag = True
                break

    if flag:
        print('YES')
    else:
        print('NO')
