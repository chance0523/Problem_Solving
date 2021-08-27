# 22858번. 원상 복구 (small)


n,k = map(int,input().split())
sList = list(map(int,input().split()))
dList_temp = list(map(int,input().split()))

dList = []
for i in range(n):
    dList.append([dList_temp[i],i])

dList.sort()

ans = [sList[i] for i in range(n)]
for i in range(k):
    temp = []
    for d in dList:
        temp.append(ans[d[1]])
    for j in range(n):
        ans[j] = temp[j]
print(*ans)