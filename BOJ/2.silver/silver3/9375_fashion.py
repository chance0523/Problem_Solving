# 9375번. 패션왕 신해빈


from itertools import combinations
from itertools import product
from collections import defaultdict
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    cDict = {}
    ans = 1
    for i in range(n):
        name, kind = input().rstrip().split()
        if kind not in cDict:
            cDict[kind] = 1
        else:
            cDict[kind] += 1
    for key in cDict.keys():
        ans = ans*(cDict[key]+1)  # 입는 것 + 안 입는 것
    print(ans-1)  # 알몸인 경우 -1
