# 11948번. 과목선택


a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())
f = int(input())

print(a+b+c+d-min(a,b,c,d)+max(e,f))