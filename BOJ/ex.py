'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

from itertools import combinations

# n <= 20이라 모든 경우의 수를 구해줘도 된다.
n,s = map(int, input().split())
nList = list(map(int,input().rstrip().split()))
cList = []
for i in range(1, n+1): # 모든 조합
    cList.extend(list(combinations([i for i in range(n)], i)))

ans = 0
for c in cList: # 각 조합마다 구해준다.
    temp = 0
    for i in range(len(c)):
        temp += nList[c[i]]
    if temp == s:
        ans += 1

print(ans)