# 2581번. 소수


m = int(input())
n = int(input())

primeList = [False for i in range(10001)]
# 소수는 false
for i in range(2, int(10000**0.5)+1):
    if not primeList[i]:
        for j in range(i+i, 10000, i):
            primeList[j] = True
primeList[1] = True
primeList[10000] = True

ansList = []
for i in range(m, n+1):
    if not primeList[i]:
        ansList.append(i)
if len(ansList) == 0:
    print(-1)
else:
    print(sum(ansList))
    print(ansList[0])
