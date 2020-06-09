n, k = map(int, input().split())
wvList = [[0 for i in range(2)] for i in range(n)]
for i in range(n):
    wvList[i][0], wvList[i][1] = map(int, input().split())

mv = 0

print(wvList)
