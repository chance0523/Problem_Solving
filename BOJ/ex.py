'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

y1, m1, d1 = map(int, input().split())
y2, m2, d2 = map(int, input().split())
man_old = 0
if m1 < m2:
    man_old = y2-y1
elif m1 == m2:
    if d1 <= d2:
        man_old = y2-y1
    else:
        man_old = y2-y1-1
else:
    man_old = y2-y1-1
count_old = y2-y1+1
year_old = y2-y1
print(man_old)
print(count_old)
print(year_old)