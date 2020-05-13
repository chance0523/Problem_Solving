# 11050번. 이항 계수 1

n, k = map(int, input().split())
if k == 0:
    print(1)
else:
    for i in range(n-k+1, n):
        n *= i

    for j in range(1, k):
        k *= j
    print(n//k)
