'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n = int(input())
if n < 2:
    print(1)
else:
    a, b = 1, 1
    for i in range(n-1):
        a, b = a + b + 1, a
    print(a % 1000000007)