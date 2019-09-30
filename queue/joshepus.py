""" from collections import deque
N, K = map(int, input().split())
q = deque()
m=[]
for i in range(1, N+1):
    q.append(i)
while len(q) > K:
    m.append(q[K-1])
    q.remove(q[K-1])
    q.rotate(-K+1)


print(m)
 """

""" N,K=map(int,input().split())
ans=list(range(1,N+1))
idx=-1
print("<",end="")
while ans:
    idx+=K
    idx=idx%(len(ans))
    if len(ans) == 1:
        print(ans.pop(idx), end=">")
    else:
        print(ans.pop(idx), end=", ")
    idx -= 1
 """

from collections import deque
N, K = map(int, input().split())
q = deque()
ans = []
for i in range(N):
    q.append(i+1)
while len(ans) != N:
    for i in range(K-1):
        a = q.popleft()
        q.append(a)
    a=q.popleft()
    ans.append(a)

print("<", end="")
for i in range(len(ans)-1):
    print(ans[i], end=", ")
print(ans[len(ans)-1], end=">")
