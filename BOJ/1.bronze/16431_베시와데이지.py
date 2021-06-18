# 16431번. 베시와 데이지


bn, bc = map(int, input().split())
dn, dc = map(int, input().split())
jn, jc = map(int, input().split())

b = max(abs(jn - bn), abs(jc - bc))
d = abs(jn - dn) + abs(jc - dc)
if b < d:
    print("bessie")
elif b > d:
    print("daisy")
else:
    print("tie")