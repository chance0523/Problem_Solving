'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = input().rstrip()
if n[:3] == '555':
    print('YES')
else:
    print('NO')