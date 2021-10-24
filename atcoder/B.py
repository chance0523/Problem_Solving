import sys
input = sys.stdin.readline

h,w = map(int,input().split())
aList = [list(map(int,input().rstrip().split())) for i in range(h)]
flag = True
for i in range(h):
    for j in range(w):
        for p in range(h):
            for q in range(w):
                if i >= p or j >= q:
                    continue
                if aList[i][j] + aList[p][q] > aList[p][j] + aList[i][q]:
                    flag = False
                    print('No')
                    exit()
print('Yes')    