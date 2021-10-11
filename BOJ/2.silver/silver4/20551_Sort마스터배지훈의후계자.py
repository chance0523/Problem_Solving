# Sort 마스터 배지훈의 후계자


import sys
input = sys.stdin.readline

n,m = map(int,input().split())
aList = []
for i in range(n):
    aList.append(int(input()))
aList.sort() # 일단 정렬

aDict = {}
for i in range(n):
    a = aList[i]
    if a not in aDict.keys(): # 처음 들어왔으면 추가
        aDict[a] = i

for i in range(m):
    d = int(input())
    if d not in aDict.keys(): # 나오지 않았었다면
        print(-1)
    else:
        print(aDict[d])
