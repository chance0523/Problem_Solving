import sys
input = sys.stdin.readline


n = int(input())
nList = list(map(int, input().split()))
nList.sort()
cost1 = nList[0]-1
cost2 = nList[0]-1
l = len(nList)-1
maxc = int(nList[-1]**(1/l))

max1 = maxc+1

# maxc
cost1 += abs(nList[1]-maxc)
cost1 += abs(nList[2]-(maxc**2))
for i in range(3, n):
    cost1 += abs(nList[i]-(maxc**i))

# max1
cost2 += abs(nList[1]-max1)
cost2 += abs(nList[2]-(max1**2))
for i in range(3, n):
    cost2 += abs(nList[i]-(max1**i))

print(min(cost1, cost2))
