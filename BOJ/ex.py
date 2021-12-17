'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n = int(input())
if n%2 == 1:
    print(0)
elif n//2 % 2 == 0:
    print(2)
else:
    print(1)