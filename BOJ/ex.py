m = int(input())
m = 1000 - m
ans = 0
if m >= 500:
    m -= 500
    ans += 1
while True:
    if m >= 100:
        m -= 100
        ans += 1
    else:
        break
while True:
    if m >= 50:
        m -= 50
        ans += 1
    else:
        break
while True:
    if m >= 10:
        m -= 10
        ans += 1
    else:
        break
while True:
    if m >= 5:
        m -= 5
        ans += 1
    else:
        break
ans += m
print(ans)
    