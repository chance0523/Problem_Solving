n = int(input())
bDict = {}
for i in range(n):
    s = input().rstrip()
    if s not in bDict:
        bDict[s] = 1
    else:
        bDict[s] += 1

ans = 0
ansBook = ''
for k in bDict.keys():
    if ans < bDict[k]:
        ans = bDict[k]
        ansBook = k
    elif ans == bDict[k]:
        if ansBook > k:
            ansBook = k
print(ansBook)