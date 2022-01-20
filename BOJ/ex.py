'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

a,b = map(int,input().split())
m = a//b
n = a%b

if a != 0 and b < 0:
    m += 1
    n -= b
print(m)
print(n)
