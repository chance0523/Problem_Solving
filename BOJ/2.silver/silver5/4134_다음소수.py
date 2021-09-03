# 4143번. 다음 소수


import math

def nextPrime(a):
    if a == 0 or a == 1:
        return 2
    while True:
        flag = True
        for i in range(2, int(math.sqrt(a)+1)):
            if a%i == 0:
                flag = False
                break
        if flag:
            return a
        a += 1
        

for _ in range(int(input())):
    n = int(input())
    print(nextPrime(n))