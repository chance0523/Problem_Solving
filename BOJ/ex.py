'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

x, k = map(int, input().split())
if k*7 <= x:
    print(k*7000)
elif k*3.5 <= x:
    print(k*3500)
elif k*1.75 <= x:
    print(k*1750)
else:
    print(0)
