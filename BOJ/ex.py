n, x = map(int, input().split())
xList = list(map(int, input().split()))

s = sum(xList[:x])
l = 0
r = x - 1
M = 0
cnt = 0
while True:
    if M < s:
        cnt = 1
        M = s
    elif M == s:
        cnt += 1
    r += 1
    if r == n:
        break
    s += xList[r]
    s -= xList[l]
    l += 1

if M == 0:
    print('SAD')
else:
    print(M)
    print(cnt)
