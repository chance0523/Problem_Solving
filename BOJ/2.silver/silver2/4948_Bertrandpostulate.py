# 4948. 베르트랑 공준
primeList = [True for _ in range(270000)]

# true : 소수
primeList[0] = False
primeList[1] = False

for i in range(2, 270000):
    if primeList[i] == False:
        continue
    for j in range(i+i, 270000, i):
        primeList[j] = False  # i의 배수들을 다 false로 만들어줌

while True:
    n = int(input())
    if n == 0:
        break
    else:
        print(sum(primeList[n+1:2*n+1]))
