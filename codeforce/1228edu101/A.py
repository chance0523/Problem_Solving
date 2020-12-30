import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    sList = list(input().rstrip())
    cnt = 0
    for i in range(len(sList)):
        if sList[i] == '?':
            cnt += 1
    if cnt % 2 == 1 or sList[0] == ')' or sList[-1] == '(':
        print('NO')
    else:
        print('YES')
