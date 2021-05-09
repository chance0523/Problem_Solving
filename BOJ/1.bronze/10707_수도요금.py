# 10707번. 수도요금


a = int(input())
b = int(input())
c = int(input())
d = int(input())
p = int(input())

x = p * a
y = b
if p <= c:
    y = b
else:
    y = b + (p - c) * d
print(min(x, y))
