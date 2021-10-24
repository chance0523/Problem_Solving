import sys
input = sys.stdin.readline

n = int(input())
nList = [list(map(int,input().rstrip().split())) for _ in range(n)]
ans = 0
for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            if (nList[i][0] - nList[j][0]) == 0 and (nList[j][0] - nList[k][0]) == 0:
                continue
            if (nList[i][0] - nList[j][0]) == 0 or (nList[j][0] - nList[k][0]) == 0:
                ans += 1
                continue
            a1 = (nList[i][1]-nList[j][1]) / (nList[i][0] - nList[j][0])
            a2 = (nList[j][1]-nList[k][1]) / (nList[j][0] - nList[k][0])
            if a1 != a2:
                ans += 1
print(ans)
            
