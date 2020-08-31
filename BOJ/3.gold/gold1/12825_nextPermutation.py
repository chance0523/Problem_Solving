# 12825번. Next Permutation


import sys
input = sys.stdin.readline

n = int(input())
nList = list(map(int, input().split()))

i = n-1
while i > 0 and nList[i-1] >= nList[i]:
    i -= 1
j = n-1
while nList[i-1] >= nList[j]:
    j -= 1
nList[i-1], nList[j] = nList[j], nList[i-1]

tList = [nList[k] for k in range(i)]
for k in range(j, n):
    tList.append(nList[k])
if abs(i-1-k) > 1:
    for k in range(j-1, i-1, -1):
        tList.append(nList[k])
print(*tList)
