nList = []
for i in range(7):
    nList.append(int(input()))

s = 0
m = 1000
for i in range(7):
    if nList[i] % 2:
        m = min(m, nList[i])
        s += nList[i]
if s:
    print(s)
    print(m)
else:
    print(-1)