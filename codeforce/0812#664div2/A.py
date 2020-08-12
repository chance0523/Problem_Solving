import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    r, g, b, w = map(int, input().split())
    # hol maximum 1
    cList = [r, g, b, w]
    jjak = 0
    hol = 0
    for i in range(len(cList)):
        if cList[i] % 2 == 0:
            jjak += 1
        else:
            hol += 1
    if(r*g*b == 0):  # no operation
        if(hol <= 1):
            print('Yes')
            continue
        else:
            print('No')
            continue

    # no operation pass
    if(jjak == 4):
        print('Yes')
        continue
    elif jjak == 3 and hol == 1:
        print('Yes')
        continue
    else:
       # one operation
        if(hol == 4):
            print('Yes')
            continue
        elif hol == 3 and jjak == 1:
            print('Yes')
            continue
        else:
            print('No')
            continue
