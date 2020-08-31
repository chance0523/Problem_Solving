# 2381번. 최대 거리


import sys
input = sys.stdin.readline

# https://blog.naver.com/programmer18/220794470677

n = int(input())
nList = [0 for i in range(n)]
maxd = 0
d = 0
for i in range(n):
    nList[i] = list(map(int, input().split()))

# c-a + b-d
# (c+d) - (a+b)

# (x+y) 값 중 최대값과 최소값
maxval = -1e9
minval = 1e9
for i in range(n):
    maxval = max(maxval, nList[i][0] + nList[i][1])
    minval = min(minval, nList[i][0] + nList[i][1])
c1 = maxval-minval

# (x-y) 의 최대값과 최소값
maxval = -1e9
minval = 1e9
for i in range(n):
    maxval = max(maxval, nList[i][0] - nList[i][1])
    minval = min(minval, nList[i][0] - nList[i][1])
c2 = maxval-minval

print(max(c1, c2))
