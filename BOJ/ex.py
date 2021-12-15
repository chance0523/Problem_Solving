'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

x,y = map(int,input().split())
ans = 1
while True:
    if y*ans - x*ans >= y:
        break
    ans += 1
print(ans)