# 14929번. 귀찮아 (SIB)


n = int(input())
xList = list(map(int,input().split()))
ans = 0
for i in range(n-1):
    for j in range(i+1, n):
        ans +=  xList[i]*xList[j]
print(ans)