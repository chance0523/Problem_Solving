'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline
from math import pi

a1, p1 = map(int,input().split())
r1, p2 = map(int,input().split())
a = p1/a1
r = p2/(r1*r1*pi)
if a < r:
    print('Slice of pizza')
else:
    print('Whole pizza')