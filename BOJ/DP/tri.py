N = int(input())
triangle=[list(map(int,input().split()))for _ in range(N)]

for i in range(N-1):
    for j in range(len(triangle[i+1])):
        if(j==0):
            triangle[i+1][j]=triangle[i][j]+triangle[i+1][j]
        elif(j == len(triangle[i + 1]) - 1):
            triangle[i + 1][-1] = triangle[i][-1] + triangle[i + 1][-1]
        else:
            triangle[i + 1][j] = max(triangle[i][j - 1] + triangle[i + 1]
                                     [j], triangle[i][j] + triangle[i + 1][j])
print(max(triangle[-1]))

