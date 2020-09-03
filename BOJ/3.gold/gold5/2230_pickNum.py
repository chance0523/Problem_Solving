# 2230번. 수 고르기


import sys
input = sys.stdin.readline

n, m = map(int, input().split())

nList = [0 for i in range(n)]
for i in range(n):
    nList[i] = int(input())

nList.sort()

diff = 0
start = 0
end = 1
ans = 2e9+1  # 범위 조심

# 투포인터 사용
while True:
    if end >= n:
        break
    diff = nList[end] - nList[start]
    if diff == m:
        ans = m
        break
    elif diff < m:
        end += 1
    else:
        ans = min(ans, diff)
        start += 1
print(ans)
