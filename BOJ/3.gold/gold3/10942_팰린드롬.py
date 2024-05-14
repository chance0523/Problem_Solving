# 10942번. 팰린드롬?


import sys
input = sys.stdin.readline

n = int(input())
nList = [0] + list(map(int, input().split()))
dp = [[False for _ in range(n+1)] for _ in range(n+1)]

for i in range(1,n+1): # 하나짜리는 무조건 팰린드롬
    dp[i][i] = True

for i in range(1,n): # 두개짜리는 두개가 같으면 팰린드롬
    if nList[i] == nList[i+1]:
        dp[i][i+1] = True

for i in range(n-1,0,-1):
    for j in range(i+2,n+1):
        if nList[i] == nList[j] and dp[i+1][j-1]:
            dp[i][j] = True

m = int(input())
for _ in range(m):
    b, e = map(int,input().split())
    if dp[b][e]:
        print(1)
    else:
        print(0)
