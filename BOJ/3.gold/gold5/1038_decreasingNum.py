# 1038번. 감소하는 수


dList = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
a = 10
for d in dList:
    t = d % a
    if d != 0 and d != 1:
        for i in range(t):
            dList.append((d*10+i))

n = int(input())
if n < len(dList):
    print(dList[n])
else:
    print(-1)
