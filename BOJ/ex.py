'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

k, w, m = map(int, input().split())
print((w-k)//m + (1 if (w-k)%m else 0))