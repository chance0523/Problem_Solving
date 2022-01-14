'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

a,b,x,y = map(int,input().split())
ans = min(abs(a - b), min(abs(a - x) + abs(b - y), abs(a - y) + abs(b - x)))
print(ans)
