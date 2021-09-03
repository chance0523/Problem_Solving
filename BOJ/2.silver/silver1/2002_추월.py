# 2002번. 추월


n = int(input())
inDict = {}
for i in range(n):
    inDict[input()] = i
outList = []
for i in range(n):
    outList.append(inDict[input()])
ans = 0
for i in range(n-1):
    for j in range(i+1, n):
        if outList[i] > outList[j]:
            ans += 1
            break
print(ans)