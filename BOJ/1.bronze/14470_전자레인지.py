# 14470번. 전자레인지


a = int(input())
b = int(input())
c = int(input())
d = int(input())
e = int(input())

ans = 0
if a < 0:
    ans = -a * c + d + b * e
else:
    ans = (b - a) * e
print(ans)
