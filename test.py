from itertools import permutations
import sys
input = sys.stdin.readline

k, n = map(int, input().split())

kDict = {}
for i in range(k):
    a = int(input())
    if a not in kDict:
        kDict[a] = 1
    else:
        kDict[a] += 1

skDict = sorted(kDict.items(), reverse=True)
print(skDict)

# 최소한 하나씩 써서 가장 큰 수를 만들기
numstr = ''
for i in range(len(skDict)):
    numstr += str(skDict[i][0])*skDict[i][1]

# 만약에 숫자 크기가 남는다면
# 제일 큰 수를 앞에다가 붙여줌
if len(numstr) != n:
    numstr = str(skDict[0][0])*(n-len(numstr))+numstr
print(numstr)
