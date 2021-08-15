# 22857번. 가장 긴 짝수 연속한 부분 수열


import sys
input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
nList = list(map(int, input().rstrip().split()))

l, r = 0, 0
cur_k = k
ans = 0
cnt = 0

while True:
    if r >= len(nList):
        break
    if nList[r] % 2 == 0:
        r += 1
        cnt += 1
    else:
        if cur_k:
            cur_k -= 1
            r += 1
        else:
            if nList[l] % 2 == 0:
                l += 1
                cnt -= 1
            else:
                l += 1
                cur_k += 1
    ans = max(ans, cnt)
print(ans)