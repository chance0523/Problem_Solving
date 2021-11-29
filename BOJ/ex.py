'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
q = deque(enumerate(map(int,input().rstrip().split())))
ans = []

while q:
    idx, num = q.popleft()
    ans.append(idx + 1)
    if num > 0:
        q.rotate(-(num - 1))
    elif num < 0:
        q.rotate(-num)

print(*ans)