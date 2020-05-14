# 10866번. 덱

# 시간초과 방지용 readline
from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
dq = deque()
for i in range(n):
    s = input().strip()
    if s.split()[0] == 'push_front':
        dq.appendleft(s.split()[1])
    elif s.split()[0] == 'push_back':
        dq.append(s.split()[1])
    elif s == 'pop_front':
        if not dq:
            print(-1)
        else:
            print(dq.popleft())
    elif s == 'pop_back':
        if not dq:
            print(-1)
        else:
            print(dq.pop())
    elif s == 'size':
        print(len(dq))
    elif s == 'empty':
        if not dq:
            print(1)
        else:
            print(0)
    elif s == 'front':
        if not dq:
            print(-1)
        else:
            print(dq[0])
    elif s == 'back':
        if not dq:
            print(-1)
        else:
            print(dq[-1])
