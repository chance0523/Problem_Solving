# 10828번. 스택

# 시간초과 방지용 readline
import sys

input = sys.stdin.readline

n = int(input())
stack = []
for i in range(n):
    s = input().strip()
    if s.split()[0] == 'push':
        stack.append(int(s.split()[1]))
    elif s == 'pop':
        if not stack:
            print(-1)
        else:
            print(stack.pop())
    elif s == 'size':
        print(len(stack))
    elif s == 'empty':
        if not stack:
            print(1)
        else:
            print(0)
    elif s == 'top':
        if not stack:
            print(-1)
        else:
            print(stack[-1])
