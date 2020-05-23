# 18870번. 좌표 압축


import sys
input = sys.stdin.readline

n = int(input())
nList = list(map(int, input().split()))

# set으로 중복 제거한 후 list로 만들어서 sort
nListS = sorted(list(set(nList)))

# nListS의 index가 곧 압축 결과이므로
# 편하게 dictionary로 계산
nDict = {}
for i in range(len(nListS)):
    nDict[nListS[i]] = i

for num in nList:
    print(nDict[num], end=' ')
