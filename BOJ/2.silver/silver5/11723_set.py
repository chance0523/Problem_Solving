# 11723번. 집합


import sys
input = sys.stdin.readline


def add(s, x):
    if x not in s:
        s.append(x)


def remove(s, x):
    if x in s:
        s.remove(x)


def check(s, x):
    if x in s:
        return 1
    else:
        return 0


def toggle(s, x):
    if x in s:
        s.remove(x)
    else:
        s.append(x)


def all(s):
    s = [i for i in range(1, 21)]
    return s


def empty(s):
    s = []
    return s


s = []

a = []
for i in range(int(input())):
    ip = input().rstrip()
    if ip == 'all':
        s = all(s)
    elif ip == 'empty':
        s = empty(s)
    else:
        c, x = ip.split()
        x = int(x)
        if c == 'add':
            add(s, x)
        elif c == 'remove':
            remove(s, x)
        elif c == 'check':
            print(check(s, x))
        elif c == 'toggle':
            toggle(s, x)

# print(a)
