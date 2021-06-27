# 11549번. Identifying tea


t = int(input())
tList = list(map(int, input().split()))
ans = 0
for tt in tList:
    if t == tt:
        ans += 1
print(ans)
