n = int(input())
nList = [float(input()) for _ in range(n)]
for i in range(1, n):
    nList[i] = max(nList[i], nList[i]*nList[i-1])
print("%.3f" % (max(nList)))