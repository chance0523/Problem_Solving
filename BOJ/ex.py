n = input()
nList = list(input().split())

ans = 0
for i in range(5):
    if nList[i][-1] == n:
        ans += 1

print(ans)
