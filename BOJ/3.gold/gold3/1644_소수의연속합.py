# 1644번. 소수의 연속합


import math, sys

n = int(input())
if n == 1:
    print(0)
    sys.exit()
# 소수 리스트 만들어주기 (에라토스테네스의 체)
pList = [True for i in range(n + 1)]
pList[1] = False
for i in range(2, int(math.sqrt(n) + 1)):
    if pList[i]:
        for j in range(i + i, n + 1, i):
            pList[j] = False

onlyPrimes = []
for i in range(2, n + 1):
    if pList[i]:
        onlyPrimes.append(i)

ans = 0
l = 0
r = 0
cur = onlyPrimes[0]
while True:
    if l > r:
        break
    if cur > n:
        cur -= onlyPrimes[l]
        l += 1
    elif cur < n:
        r += 1
        if r == len(onlyPrimes):
            break
        cur += onlyPrimes[r]
    else:
        ans += 1
        r += 1
        if r == len(onlyPrimes):
            break
        cur += onlyPrimes[r]
print(ans)