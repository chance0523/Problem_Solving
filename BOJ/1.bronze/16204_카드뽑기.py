# 16204번. 카드 뽑기


n,m,k = map(int,input().split())
o = min(m,k)
x = min(n-m,n-k)
print(o+x)