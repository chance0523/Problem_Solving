import sys
from itertools import combinations
input = sys.stdin.readline
sys.setrecursionlimit(5000)

cList = []
for i in range(1, 11):
    temp = list(combinations([j for j in range(1, 10)], i))
    cList.extend(temp)
# print(cList)

nList = []
sumList = []
strList = []
for i in range(len(cList)):
    sum_ = sum(cList[i])
    str_ = ''.join(map(str, cList[i]))
    sumList.append(sum_)
    strList.append(str_)

for _ in range(int(input())):
    x = int(input())
    if x not in sumList:
        print(-1)
        continue
    for i in range(len(sumList)):
        if sumList[i] == x:
            print(strList[i])
            break
