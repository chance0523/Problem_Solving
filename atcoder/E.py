import sys
input = sys.stdin.readline

n,k = map(int,input().rstrip().split())
aList = list(map(int,input().rstrip().split()))
aList.sort(reverse=True)
temp = [aList[0]]

for i in range(1,n):
    if temp[0] != aList[i]:
        break
    else:
        temp.append(aList[i])
ans = 0

while True:
    if k == 0 or temp[0] == 0:
        break
    nex = aList[len(temp)]
    if temp[0] == nex:
        temp.append(nex)
    diff = temp[0] - nex
    
    