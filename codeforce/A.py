import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int,input().rstrip().split()))
    a = nList[0]
    if n==1:
        print(a)
        continue
    for i in range(1,n):
        a = a&nList[i]
    print(a)
