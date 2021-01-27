# 1977번. 완전제곱수


import sys
input = sys.stdin.readline

m = int(input())
n = int(input())
nList = [i**2 for i in range(101)]  # 완전 제곱수들 저장

sum = 0
ans = 10001
for i in range(1, len(nList)):  # 0 제외
    if m <= nList[i] <= n:  # 조건 만족
        sum += nList[i]
        ans = min(ans, nList[i])

if sum == 0:
    print(-1)
else:
    print(sum)
    print(ans)
