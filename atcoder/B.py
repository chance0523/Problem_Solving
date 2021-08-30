import sys
input = sys.stdin.readline

n = int(input())
nList=[]
for i in range(n):
    nList.append(input().rstrip())
nSet = list(set(nList))
if len(nList) != len(nSet):
    print('Yes')
else:
    print('No')