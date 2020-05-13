# 1259번. 팰린드롬수


def p(n):
    if n[0] != n[-1]:
        return 'no'
    else:
        i = 1
        while i <= (len(n)//2):
            if n[i] != n[-i-1]:
                return 'no'
            else:
                i += 1
        return 'yes'


while True:
    n = input()
    if n == '0':
        break
    print(p(n))
