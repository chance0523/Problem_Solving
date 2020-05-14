# 2805번. 나무 자르기

# pypy로 해야 시간초과 없이 성공

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
tList = list(map(int, input().split()))

left = 1
right = max(tList)

while left <= right:
    mid = (left+right)//2
    sum = 0
    for t in tList:
        if t >= mid:
            sum += (t-mid)
    if sum >= m:
        left = mid+1
    else:
        right = mid-1

print(right)
