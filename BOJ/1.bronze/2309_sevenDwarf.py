# 2309번. 일곱 난쟁이


from itertools import combinations
import sys
input = sys.stdin.readline

# 일곱 난쟁이의 키의 합이 100
nList = []
for i in range(9):
    nList.append(int(input()))
cList = list(combinations(nList, 7))
for i in range(len(cList)):
    if sum(cList[i]) == 100:
        for j in range(7):
            print(sorted(list(cList[i]))[j])
        break
