# 10815번. 숫자 카드


import sys
input = sys.stdin.readline

n = int(input())
cset = set(map(int, input().split()))
m = int(input())
nList = list(map(int, input().split()))


for i in range(m):
    if nList[i] in cset:
        print(1, end=' ')
    else:
        print(0, end=' ')
