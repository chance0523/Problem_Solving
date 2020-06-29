# 1158번. 요세푸스 문제


n, k = map(int, input().split())
nList = [i for i in range(1, n+1)]
ansList = []
idx = k-1
while True:
    ansList.append(nList.pop(idx))
    if not nList:
        break
    idx = (idx+k-1) % len(nList)
print('<'+', '.join(map(str, ansList))+'>')
