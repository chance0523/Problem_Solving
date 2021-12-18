'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


a = int(input())
b = int(input())
c = int(input())
d = int(input())

if (a==8 or a==9) and (d==8 or d==9) and b == c:
    print('ignore')
else:
    print('answer')