# 1918번. 후위 표기식


a = input().rstrip()

priority = {
    '*': 2,
    '/': 2,
    '+': 1,
    '-': 1,
    '(': 0
}
stack = []

for c in '('+a+')':
    # print('\n', stack)
    if 'A' <= c <= 'Z':
        print(c, end='')
    elif c == '(':
        stack.append(c)
    elif c == ')':
        while True:
            o = stack.pop()
            if o == '(':
                break
            print(o, end='')
    else:
        while stack[-1] != '(' and priority[c] <= priority[stack[-1]]:
            print(stack.pop(), end='')
        stack.append(c)
