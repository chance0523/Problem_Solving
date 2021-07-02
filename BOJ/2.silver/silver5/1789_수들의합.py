# 1789번. 수들의 합


s = int(input())
su = 0
for i in range(1, 500000):
    su += i
    if su > s:
        print(i - 1)
        break