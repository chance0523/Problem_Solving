# 14395번. 4연산


import sys
from collections import deque

s,t = map(int,input().split())

q = deque()
v = set()

q.append([s, ''])
v.add(s)
MAX = 10e9

if s==t:
    print(0)
else:
    ans = -1
    while q:
        num, op = q.popleft()
        if num == t:
            ans = op
            print(ans)
            sys.exit(0)
        next = num * num
        if 0 <= next <= MAX and next not in v:
            q.append([next, op + '*'])
            v.add(next)
            
        next = num + num
        if 0 <= next <= MAX and next not in v:
            q.append([next, op + '+'])
            v.add(next)
        
        next = 1
        if next not in v:
            q.append([next, op + '/'])
            v.add(next)
    print(ans)