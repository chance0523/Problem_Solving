'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

p1, q1, p2, q2 = map(int, input().split())
ans = p1/q1 * p2/q2 / 2
if int(ans) == ans:
    print(1)
else:
    print(0)
