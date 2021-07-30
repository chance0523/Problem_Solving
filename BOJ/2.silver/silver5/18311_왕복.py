# 18311번. 왕복


n,k = map(int,input().split())
nList = list(map(int,input().split()))
for i in range(1,n+1):
    nList.append(nList[n-i])
# 지나야할 코스번호
kList = [[0,0]]
for i in range(n):
    kList.append([kList[i][0]+nList[i],i+1])
for i in range(n,len(nList)):
    kList.append([kList[i][0]+nList[i],len(nList)-i])
ans = 0
for i in range(1, len(kList)):
    if kList[i-1][0] <= k < kList[i][0]:
        ans = kList[i][1]
        break
print(ans)