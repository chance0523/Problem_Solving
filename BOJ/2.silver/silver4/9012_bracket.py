# 9012번. 괄호

t = int(input())


def isVPS(sList):
    cnt = 0
    for s in sList:
        if cnt == 0:
            if s == '(':
                cnt += 1
            # )이 먼저 나오면 NO
            elif s == ')':
                return 'NO'
        else:
            if s == '(':
                cnt += 1
            elif s == ')':
                cnt -= 1
    if cnt == 0:
        return 'YES'
    else:
        return 'NO'


for i in range(t):
    sList = list(input())
    print(isVPS(sList))
