# 2442번. 별 찍기 - 5


n = int(input())
for i in range(0, n):
    print(" " * (n - i - 1) + "*" * i + "*" + "*" * i)