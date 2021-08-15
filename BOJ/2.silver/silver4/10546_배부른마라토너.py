# 10546번. 배부른 마라토너


import sys
input = sys.stdin.readline

n = int(input().rstrip())
sDict = {}
for i in range(n):
    s = input().rstrip()
    if s not in sDict:
        sDict[s] = 1
    else:
        sDict[s] += 1

for i in range(n-1):
    s = input().rstrip()
    sDict[s] -= 1

for key, value in sDict.items():
    if value != 0:
        print(key)
        break