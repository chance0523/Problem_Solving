# 2166번. 다각형의 면적


# https://darkpgmr.tistory.com/86
import sys
input = sys.stdin.readline


n = int(input())
nList = [[0, 0] for i in range(n+1)]

for i in range(n):
    a, b = map(int, input().split())
    nList[i][0] = a
    nList[i][1] = b

nList[n][0] = nList[0][0]
nList[n][1] = nList[0][1]

s = 0
for i in range(n):
    s += ((nList[i][0]*nList[i+1][1])/2 - (nList[i+1][0]*nList[i][1])/2)
if s < 0:
    s *= -1
s = round(s, 1)
print(s)
