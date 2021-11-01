'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n, s = map(int,input().split())

nList = []
for i in range(n):
    nList.append(int(input()))

ans = 0
for i in range(n-1):
    for j in range(i + 1, n):
        if nList[i] + nList[j] <= s:
            ans += 1
print(ans)