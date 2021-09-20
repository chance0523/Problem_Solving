import sys
input = sys.stdin.readline

xList = list(input().rstrip())
xDict = {}
for i in range(len(xList)):
    xDict[xList[i]] = i
n = int(input())
ansList = []
for i in range(n):
    s = input().rstrip()
    temp = ''
    for j in range(len(s)):
        temp += chr(ord('a')+xDict[s[j]])
    ansList.append([temp, s])
ansList.sort()
for i in range(len(ansList)):
    print(ansList[i][1])