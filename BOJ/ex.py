'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline
from itertools import combinations

n,m = map(int,input().split())
cList = list(combinations([i for i in range(m)], 3)) # 전체 경우
nList = [list(map(int,input().rstrip().split())) for _ in range(n)] 

ans = 0
for c in cList:
    cur = 0
    for i in range(n):
        temp = 0
        for j in range(3):
            temp = max(temp, nList[i][c[j]])
        cur += temp
    ans = max(ans, cur)

print(ans)

