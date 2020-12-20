import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(input().rstrip())
    nList = nList[::-1]
    cnt = 0
    for i in range(n):
        if nList[i] == ')':
            cnt += 1
        else:
            break
    if cnt > n - cnt:
        print('Yes')
    else:
        print('No')
