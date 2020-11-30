nList = [0 for i in range(5)]
for i in range(5):
    nList[i] = sum(list(map(int, input().split())))
print(nList.index(max(nList)) + 1, end=' ')
print(max(nList))
