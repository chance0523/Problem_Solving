'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


a = 0
b = 0
a += 3 * int(input())
a += 2 * int(input())
a += 1 * int(input())

b += 3 * int(input())
b += 2 * int(input())
b += 1 * int(input())

if a > b:
    print('A')
elif a < b:
    print('B')
else:
    print('T')