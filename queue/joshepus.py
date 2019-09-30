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
    print(idx)
    if len(ans) == 1:
        print(ans.pop(idx), end=">")
    else:
        print(ans.pop(idx), end=", ")
    idx -= 1 """
print(2 % 7)
