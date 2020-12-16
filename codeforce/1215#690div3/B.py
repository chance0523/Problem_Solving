import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    s = input().rstrip()
    ans = 0
    if s[:4] == '2020':
        ans = 1
    elif s[:-4] == '2020':
        ans = 1
    elif s[:3] == '202' and s[-1] == '0':
        ans = 1
    elif s[:2] == '20' and s[-2:] == '20':
        ans = 1
    elif s[:1] == '2' and s[-3:] == '020':
        ans = 1
    elif s[-4:] == '2020':
        ans = 1
    else:
        ans = 0
    if ans:
        print('YES')
    else:
        print('NO')
