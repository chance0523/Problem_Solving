from itertools import combinations
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    nList.sort(reverse=True)
    # XOR : same -> 0, different -> 1
    cList = list(combinations(nList, n//2+1))
    for c in cList:
        ans = c[0]
        for i in range(1, len(c)):
            ans ^= c[i]
        print(c, ans)
