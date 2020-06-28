# B. Multiply by 2, divide by 6


import sys
input = sys.stdin.readline

t = int(input())

primeList = [False for i in range(1003002)]

for i in range(2, len(primeList)):
    if not primeList[i]:
        for j in range(i+i, len(primeList), i):
            primeList[j] = True

realPrimeList = []
for i in range(2, len(primeList)):
    if not primeList[i]:
        realPrimeList.append(i)

for _ in range(t):
    n = int(input())
    if n == 1:
        print(0)
        continue
    result = {}
    for p in realPrimeList:
        degree = 0
        while n % p == 0:
            degree += 1
            n = n//p
        result[p] = degree
        if n == 1:
            break

    rList = []
    for i in result:
        if result[i] != 0:
            rList.append([i, result[i]])
    if len(rList) >= 3:
        print(-1)
        continue
    elif len(rList) == 2:
        if rList[0][0] == 2 and rList[1][0] == 3:
            if rList[0][1] > rList[1][1]:
                print(-1)
                continue
            else:
                ans = rList[0][1]+(rList[1][1]-rList[0][1])*2
                print(ans)
                continue
        else:
            print(-1)
            continue
    elif len(rList) == 1:
        if rList[0][0] == 3:
            ans = rList[0][1]*2
            print(ans)
            continue
        else:
            print(-1)
            continue
