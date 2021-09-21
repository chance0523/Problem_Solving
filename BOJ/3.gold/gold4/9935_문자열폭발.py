# 9935번. 문자열 폭발


string = input().rstrip()
p = input().rstrip()
l = len(p)
stack = []

for s in string:
    stack.append(s)
    if s == p[-1] and ''.join(stack[-l:]) == p:
        for j in range(l):
            stack.pop()

ans = ''.join(stack)
if len(ans) == 0:
    print('FRULA')
else:
    print(ans)