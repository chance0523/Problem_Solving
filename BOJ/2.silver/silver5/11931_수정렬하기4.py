# 11931번. 수 정렬하기 4


import sys
input = sys.stdin.readline

n = int(input())
nList = []
for i in range(n):
    nList.append(int(input()))
nList.sort(reverse=True)
for num in nList:
    print(num)
