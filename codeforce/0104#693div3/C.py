import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = [0]+list(map(int, input().split()))
    aList = []
    for i in range(n+1):
        aList.append(i + nList[i])
    print(aList)
