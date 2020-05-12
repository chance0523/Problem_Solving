# 2475번. 검증수

a1, a2, a3, a4, a5 = map(int, input().split(' '))
v = (a1*a1+a2*a2+a3*a3+a4*a4+a5*a5) % 10
print(v)
