'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

b = int(input())
p = 5 * b - 400
print(p)
if p < 100:
    print(1)
elif p == 100:
    print(0)
else:
    print(-1)