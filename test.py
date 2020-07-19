n,k,m = map(int,input().split())

# nCk = nCn-k
if n//2<k:
    k=n-k
s=1
for i in range(k):
    s*=(n-i)
    
mom=1
for i in range(2,k+1):
    mom*=i
print((s//mom)%m)