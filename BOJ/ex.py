'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

a,p = map(int,input().split())
a *= 7
p *= 13
if a > p:
    print('Axel')
elif a < p:
    print('Petra')
else:
    print('lika')