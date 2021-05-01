a, b, c = map(int, input().split())
ans = 0
if a == b == c:
    ans = 10000 + a * 1000
elif a == b:
    ans = 1000 + a * 100
elif b == c:
    ans = 1000 + b * 100
elif c == a:
    ans = 1000 + c * 100
else:
    ans = max(a, b, c) * 100
print(ans)
