'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = int(input())
nList = list(map(int,input().rstrip().split()))
nList.sort()
l=0
r=n-1
m = nList[l]+nList[r]
ans = [l, r]
while l<r:
    cur = nList[l] + nList[r]
    if abs(cur) < abs(m):
        m = cur
        ans = [l,r]
        if ans == 0:
            break
    if cur < 0:
        l += 1
    else:
        r -= 1
print(nList[ans[0]], nList[ans[1]])
            