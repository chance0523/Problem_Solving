'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

x, l, r = map(int, input().split())
ans = 0
m = 1e9
for i in range(l, r+1):
    if abs(x-i) < m:
        m = abs(x-i)
        ans = i
print(ans)