# 1009번. 분산처리


import sys
input = sys.stdin.readline

for _ in range(int(input())):
    a, b = map(int, input().split())
    ans = pow(a,b,10)
    if ans == 0:
        print(10)
    else:
        print(ans)
