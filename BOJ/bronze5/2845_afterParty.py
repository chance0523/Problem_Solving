# 2845번. 파티가 끝나고 난 뒤

l, p = map(int, input().split(' '))
a1, a2, a3, a4, a5 = map(int, input().split(' '))
t = l*p  # total
b1 = a1-t
b2 = a2-t
b3 = a3-t
b4 = a4-t
b5 = a5-t
print(b1, b2, b3, b4, b5)
