'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

x1, y1, x2, y2 = map(int, input().rstrip().split())
x3, y3, x4, y4 = map(int, input().rstrip().split())
x = max(x2, x4) - min(x1, x3)
y = max(y2, y4) - min(y1, y3)
print(max(x, y)**2)