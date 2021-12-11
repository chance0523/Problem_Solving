'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = '9780921418' + input().rstrip() + input().rstrip() + input().rstrip()

ans = 0
for i in range(len(n)):
    if i % 2:
        ans += int(n[i]) * 3
    else:
        ans += int(n[i]) * 1
print(f'The 1-3-sum is {ans}')
