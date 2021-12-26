'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

A1 = int(input())
A2 = int(input())
A3 = int(input())
r1 = A2*2 + A3*4
r2 = A1*2 + A3*2
r3 = A1*4 + A2*2
print(min(r1, r2, r3))