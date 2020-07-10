import sys
input = sys.stdin.readline

n = int(input())
nList = [0 for i in range(n)]
for i in range(n):
    nList[i] = int(input())
print(nList)
