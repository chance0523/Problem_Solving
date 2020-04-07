T=int(input())

dx=[0,0,1,-1]
dy=[1,-1,0,0]


def dfs(m,n,k,garden,x,y,cnt):
    garden[x][y]=0

    queue=[]
    queue.append((x,y))
    while len(queue)>0:
        x,y=queue.pop(0)
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            if nx>=0 and nx<n and ny>=0 and ny>m:
                if garden[nx][ny]==1:
                    cnt+=1
                    garden[nx][ny]=0
                    queue.append((nx,ny))
    return cnt




cnt=0
ans=[]
for i in range(T):
    m,n,k=map(int,input().split())
    garden=[[0]*m for _ in range(n)]
    visited = [[0]*m for _ in range(n)]
    for _ in range(k):     
        b,a=map(int,input().split())
        garden[a][b]=1

    for b in range(m):
        for a in range(n):
            if garden[a][b]==1:
                ans.append(dfs(m,n,k,garden,a,b,cnt))
    
print(ans)


