# 14929번. 귀찮아 (SIB)


n = int(input())
xList = list(map(int,input().split()))
s = sum(xList)
ans = 0
for i in range(n):
    s -= xList[i]
    ans += xList[i] * s
print(ans)