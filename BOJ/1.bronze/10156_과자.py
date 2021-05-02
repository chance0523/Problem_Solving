# 10156번. 과자


k, n, m = map(int, input().split())
ans = n*k - m
print(0 if ans < 0 else ans)
