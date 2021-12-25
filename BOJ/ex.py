'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

w, h = map(int, input().split())
ans = w+h - (w**2 + h**2)**0.5
print(ans)