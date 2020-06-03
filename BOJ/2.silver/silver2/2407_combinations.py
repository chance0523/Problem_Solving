# 2407번. 조합


import sys
input = sys.stdin.readline

n, m = map(int, input().split())

son = 1  # 분자
for i in range(n-m+1, n+1):
    son *= i

mom = 1  # 분모
for i in range(1, m+1):
    mom *= i

ans = son//mom
print(ans)
