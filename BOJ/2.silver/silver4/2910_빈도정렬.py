# 2910번. 빈도정렬


import sys
input = sys.stdin.readline

n, c = map(int, input().split())
nList = list(map(int, input().rstrip().split()))
s = list(set(nList))  # 몇개의 숫자로 구성되어있는지
s.sort()
aDict = {}
for k in s:
    aDict[k] = [0, 0]

num = len(s)
for k in nList:
    if aDict[k][1] == 0:  # 처음 나왔다면 몇번째인지 체크
        aDict[k][1] = num
        num -= 1  # 숫자가 클수록 빨리 나옴
    aDict[k][0] += 1

ans = []
for k in aDict.keys():  # 딕셔너리 분해
    temp = [aDict[k][0], aDict[k][1], k]
    ans.append(temp)
ans.sort(reverse=True)

for i in range(len(ans)):
    for j in range(ans[i][0]):
        print(ans[i][2], end=' ')
