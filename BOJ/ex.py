'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


t = int(input())
x = [0 for _ in range(t*2 + 1)]
for i in range(1, t*2, 2):
    x[i] = int(input())

m = 10001
for a in range(m):
    for b in range(m):
        flag = True
        for i in range(2, t*2+1, 2):
            x[i] = (a*x[i-1] + b) % m
            if i+1 <= t*2 and x[i+1] != (a*x[i] + b)%m:
                flag = False
                break
        if flag:
            for i in range(2, t*2+1, 2):
                print(x[i])
            sys.exit()

