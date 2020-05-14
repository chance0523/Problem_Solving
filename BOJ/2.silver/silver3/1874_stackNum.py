# 1874번. 스택 수열

import sys
input = sys.stdin.readline

n = int(input())

stack = []
op = []
cnt = 1
flag = True

# 4,3,6,8,7,5,2,1
for i in range(n):
    num = int(input())
    while cnt <= num:
        # 1,2,3,4를 담는다
        stack.append(cnt)
        op.append('+')
        cnt += 1
    if stack[-1] == num:
        # 4,3을 pop
        stack.pop()
        op.append('-')
    else:
        flag = False
if flag == False:
    print('NO')
else:
    for i in op:
        print(i)
