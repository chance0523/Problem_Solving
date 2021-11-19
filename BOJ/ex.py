'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

def func(a, b, op):
    if op == '+':
        return a+b
    elif op == '-':
        return a-b
    elif op == '*':
        return a*b
    elif op == '/':
        return -1*(abs(a)//abs(b)) if a*b < 0 else a//b

sList = list(input().rstrip().split())
a = int(sList[0])
b = int(sList[2])
c = int(sList[4])

op1 = sList[1]
op2 = sList[3]

ans1 = func(func(a,b,op1), c, op2)
ans2 = func(a, func(b, c, op2), op1)
if ans1 > ans2: # 작은거부터 출력
    ans1, ans2 = ans2, ans1

print(ans1)
print(ans2)