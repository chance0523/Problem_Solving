'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n,m = map(int,input().split())
kList = list(map(int,input().rstrip().split()))
ans = 0
for i in range(1, n+1):
    for k in kList:
        if i % k == 0:
            ans += i
            break
print(ans)