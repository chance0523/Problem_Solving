'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n, m = map(int,input().rstrip().split())
if m != 0:
    sList = list(map(int,input().rstrip().split()))
else:
    sList = []

aList = [False for i in range(1002)]
for s in sList:
    aList[s] = True

ans = int(1e9)
for x in range(1, 1001):
    if aList[x]:
        continue
    for y in range(x, 1001):
        if aList[y]:
            continue
        for z in range(y, 1002):
            if aList[z]:
                continue
            cur = x*y*z
            ans = min(ans, abs(n-cur))
            if n == cur:
                break
print(ans)