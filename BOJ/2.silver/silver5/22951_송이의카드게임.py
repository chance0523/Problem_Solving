# 22951번. 송이의 카드 게임

from collections import deque
q = deque([])

n,k = map(int,input().split())
for i in range(1,n+1):
    lst = list(map(int,input().split()))
    for l in lst:
        q.append([i,l])

t = q.popleft()
member = t[0]
num = t[1]
while True:
    if len(q) == 0:
        break
    for i in range(num-1):
        q.append(q.popleft())
    t = q.popleft()
    member = t[0]
    num = t[1]

print(member, num)