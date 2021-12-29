'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

h, w = map(int, input().split())
a, b = max(h, w), min(h, w)
l1 = a/3 if a/3 <= b else b
l2 = b/2
print(max(l1, l2))