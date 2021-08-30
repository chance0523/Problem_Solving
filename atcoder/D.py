import sys
input = sys.stdin.readline

n,m = map(int,input().rstrip().split())
aDict = {}
for i in range(m):
    k = int(input())
    aList = list(map(int,input().rstrip().split()))
    for j in range(len(aList)):
        if aList[j] not in aDict:
            aDict[aList[j]] = [i]
        else:
            aDict[aList[j]].append(i)
