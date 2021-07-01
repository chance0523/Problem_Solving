# 1292번. 쉽게 푸는 문제


a, b = map(int,input().split())
nList = []
for i in range(1, 2000):
    for j in range(i):
        nList.append(i)
print(sum(nList[a-1:b]))