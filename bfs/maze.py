x, y = map(int, input().split())
matrix = [list(map(int, list(input()))) for _ in range(x)]

dx=[0,0,1,-1]
dy=[1,-1,0,0]

visited=[[0]*y for _ in range(x)]

arr=[]
arr.append((0,0))
visited[0][0]=1

while arr:
    a,b=arr.pop(0)
    if a==x-1 and b==y-1:
        print(visited[a][b])
        break
    else:
        for i in range(4):
            ax=a+dx[i]
            ay=b+dy[i]
            if ax>=0 and ax<x and ay>=0 and ay<y:
                if visited[ax][ay]==0 and matrix[ax][ay]==1:
                    visited[ax][ay]=visited[a][b]+1
                    arr.append((ax,ay))

print(visited)
print(matrix)
