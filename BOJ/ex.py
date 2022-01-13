'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

S = int(input())
M = int(input())
L = int(input())
print("happy" if S*1 + M*2 + L*3 >= 10 else "sad")
