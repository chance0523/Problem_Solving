'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

a,b = map(int,input().split())
if a%2 and b%2:
    print(min(a,b))
else:
    print(0)