# 2018번. 수들의 합 5


n = int(input())
ans = 0
l = 0
r = 1
s = 1
while l <= n and r <= n:
    if s == n:
        r += 1
        s = s - l + r
        l += 1
        ans += 1
    elif s > n:
        s -= l
        l += 1
    elif s < n:
        r += 1
        s += r
print(ans)