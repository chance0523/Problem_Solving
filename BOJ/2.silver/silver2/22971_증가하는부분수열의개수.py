# 22971번. 증가하는 부분 수열의 개수


n = int(input())
nList = list(map(int,input().split()))
mod = 998244353
ans = [0 for i in range(n)]
ans[0] = 1

for i in range(1,n):
    for j in range(i):
        if 