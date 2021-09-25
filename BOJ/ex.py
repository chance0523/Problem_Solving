n = int(input())
cnt = 0
for i in range(n, -1, -1):
    ans = ''
    for j in range(cnt):
        ans += ' '
    ans += '*' * (2 * i - 1)
    print(ans)
    cnt += 1
