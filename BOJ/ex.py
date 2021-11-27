'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

b1 = input()
b2 = input()
ans = bin(int(b1, 2) * int(b2, 2))[2:]
print(ans)