import sys
input = sys.stdin.readline


t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    nList = list(map(int, input().split()))
    mList = list(map(int, input().split()))

    flag = False
    for i in nList:
        if i in mList:
            print('YES')
            print(1, i)
            flag = True
            break
    if flag == False:
        print('NO')
