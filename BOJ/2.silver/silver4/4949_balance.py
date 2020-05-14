# 4949번. 균형잡힌 세상


import sys
input = sys.stdin.readline

while True:
    sList = input().rstrip()
    if sList == '.':
        break
    stack = []
    f = True
    for s in sList:
        if s == '(' or s == '[':
            stack.append(s)
        elif s == ')':

            if stack and stack[-1] == '(':
                stack.pop()
            else:
                f = False
                break
        elif s == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                f = False
                break
    if not stack and f == True:
        print('yes')
    else:
        print('no')
