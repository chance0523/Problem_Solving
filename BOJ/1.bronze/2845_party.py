# 2845번. 파티가 끝나고 난 뒤


import sys
input = sys.stdin.readline

l, p = map(int, input().split())
a = list(map(int, input().split()))
san = l*p
for i in range(5):
    print(a[i]-san, end=' ')
