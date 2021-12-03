'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

s = input().rstrip().split()
a = int(s[0])
b = int(s[2])
c = int(s[4])
if a+b == c:
    print('YES')
else:
    print('NO')