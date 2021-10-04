import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n,x=map(int,input().split())
    nList = list(map(int,input().rstrip().split()))
    if x == 1:
        print('YES')
        continue
    flag = True
    for i in range(n-1):
        if nList[i] > nList[i+1]:
            flag = False
            break
    if flag:
        print('YES')
        continue
    else:
        if x >= n:
            print('NO')
            continue
    print('YES')
