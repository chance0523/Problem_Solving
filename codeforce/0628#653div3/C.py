import sys
input = sys.stdin.readline


def func():
    res = 0
    init = 0
    while True:
        cur = init
        ok = True
        for i in range(len(s)):
            res += 1
            if s[i] == '+':
                cur += 1
            else:  # '-'
                cur -= 1
            if cur < 0:
                ok = False
                init += 1
                break
        if ok:
            break
    print(res)


for _ in range(int(input())):
    s = list(input().rstrip())
    func()
