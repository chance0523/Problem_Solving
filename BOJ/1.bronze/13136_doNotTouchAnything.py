# 13136번. Do Not Touch Anythin


r,c,n = map(int,input().split())
a = r//n + 1 if r%n else r//n
b = c//n + 1 if c%n else c//n
print(a*b)