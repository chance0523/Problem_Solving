import sys
input = sys.stdin.readline


t = int(input())

s = []
i = 1
M = 10**18
while True:
    num = 2*(4**i - 1)//3 - 2**i + 1
    if num > M:
        break
    else:
        s.append(num)
        i += 1
# print(s)


for _ in range(t):
    n = int(input())
    ans = 0
    for i in s:
        if n >= i:
            ans += 1
        else:
            break
    print(ans)
