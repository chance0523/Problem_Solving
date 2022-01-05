'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

a,b,c = map(int,input().split())
one = 0
two = 0
if a == 1:
    one += 1
else:
    two += 1
if b == 1:
    one += 1
else:
    two += 1
if c == 1:
    one += 1
else:
    two += 1

if one > two:
    print(1)
else:
    print(2)