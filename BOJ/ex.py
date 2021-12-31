'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

pList = [False for _ in range(1000)]
pList[0] = True
pList[1] = True
for i in range(2, 1000):
    for j in range(i+i, 1000, i):
        pList[j] = True
primes = []
for i in range(len(pList)):
    if not pList[i]:
        primes.append(i)
muls = []
for i in range(len(primes)-1):
    muls.append(primes[i] * primes[i+1])

n = int(input())
for i in range(len(muls)):
    if muls[i] > n:
        print(muls[i])
        break
