import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    while True:
        flag = True
        tmp = n
        while True:
            if tmp == 0:
                break
            if tmp % 10 == 0:
                tmp //= 10
            else:
                if n % (tmp % 10) == 0:
                    tmp //= 10
                else:
                    flag = False
                    break
        if flag:
            print(n)
            break
        else:
            n += 1
