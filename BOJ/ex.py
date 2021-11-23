'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())
check = False

for i in range(1, a):
    temp = a * i + b * c

    if temp ** 2 == ((a * a - b * b) * (a * a - c * c)):
        check = i

print(-1) if not check else print(check)