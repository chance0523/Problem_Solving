# 10989번. 수 정렬하기 3
import sys
input = sys.stdin.readline

n = int(input())
# 메모리에 주의 !!!
nList = [0]*10001

for i in range(n):
    nList[int(input())] += 1

for i in range(10001):
    if nList[i] != 0:
        for j in range(nList[i]):
            print(i)
