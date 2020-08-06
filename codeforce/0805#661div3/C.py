import sys
input = sys.stdin.readline

t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    box = [[0 for i in range(n)] for i in range(n)]

    for i in range(n-1):
        for j in range(i+1, n):
            box[i][j] = nList[i]+nList[j]

    for i in range(n):
        for j in range(i+1, n-1):
            if box[i][j] != 0:
                for k in range(j+1, n):
                    if box[i][j] == box[i][k]:
                        box[i][k] = 0

    for i in range(n):
        for j in range(n-1):
            if box[j][i] != 0:
                for k in range(j+1, n):
                    if box[j][i] == box[k][i]:
                        box[k][i] = 0

    countList = [0 for i in range(1000)]

    for i in range(n-2):
        if box[i][i+1] == box[i+1][i+2]:
            box[i+1][i+2] = 0

    for i in range(n):
        for j in range(n):
            if(box[i][j] != 0):
                countList[box[i][j]] += 1

    print(max(countList))
