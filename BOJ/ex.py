'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = int(input())
ans = 4
a = 2
b = 1
for i in range(n):
    a += b
    ans = a ** 2
    b *= 2
print(ans)
            