import sys
input = sys.stdin.readline


# 1,4,6,8,9
# 2,3,5,7
# 25,27,35,57
# 32,52,72,75
# 25-52
# 57-75
# 32

# 23 37 73
# 237 ok
# 327 ok
# 273 ok
# 372 ok
# 732 ok
# 723 ok

for _ in range(int(input())):
    k = int(input())
    n = list(input().rstrip())
    dec = [0 for i in range(10)]
    if '1' in n:
        print(1)
        print(1)
        continue
    if '4' in n:
        print(1)
        print(4)
        continue
    if '6' in n:
        print(1)
        print(6)
        continue
    if '8' in n:
        print(1)
        print(8)
        continue
    if '9' in n:
        print(1)
        print(9)
        continue
    if '2' in n and n.count('2') >= 2:
        print(2)
        print(22)
        continue
    if '3' in n and n.count('3') >= 2:
        print(2)
        print(33)
        continue
    if '5' in n and n.count('5') >= 2:
        print(2)
        print(55)
        continue
    if '7' in n and n.count('7') >= 2:
        print(2)
        print(77)
        continue
    if '2' in n and '5' in n:
        print(2)
        if n.index('2') > n.index('5'):
            print(52)
        else:
            print(25)
        continue
    if '5' in n and '7' in n:
        print(2)
        if n.index('5') > n.index('7'):
            print(75)
        else:
            print(57)
        continue
    if '2' in n and '7' in n:
        print(2)
        if n.index('2') > n.index('7'):
            print(72)
        else:
            print(27)
        continue
    if '3' in n and '2' in n:
        if n.index('3')<n.index('2'):
            print(2)
            print(32)
            continue
    if '3' in n and '5' in n:
        if n.index('3')<n.index('5'):
            print(2)
            print(35)
            continue
# 237 ok
# 327 ok
# 273 ok
# 372 ok
# 732 ok
# 723 ok