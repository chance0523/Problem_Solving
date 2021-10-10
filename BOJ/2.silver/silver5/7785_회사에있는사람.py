# 7785번. 회사에 있는 사람


import sys
input = sys.stdin.readline

n = int(input())
nDict = {}
for i in range(n):
    name, status = input().rstrip().split()
    if status == 'enter':
        nDict[name] = 1
    else:
        nDict[name] = 0

ans = []
for name in nDict.keys():
    if nDict[name] == 1:
        ans.append(name)
ans.sort(reverse=True)
for a in ans:
    print(a)