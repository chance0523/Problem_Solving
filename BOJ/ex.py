'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

h1, m1, s1 = map(int, input().split(':'))
h2, m2, s2 = map(int, input().split(':'))
t1 = h1*3600 + m1*60 + s1
t2 = h2*3600 + m2*60 + s2
if t1 > t2:
    print(t2-t1+3600*24)
else:
    print(t2-t1)