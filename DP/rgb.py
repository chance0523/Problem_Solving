N=int(input())
rgblist=[]

for i in range(N):
    r,g,b=map(int,input().split())
    rgblist.append([r,g,b])

dp=[]

dp.append(rgblist[0])

for i in range(1,N):
    temp=[]
    temp.append(min(dp[i-1][1],dp[i-1][2])+rgblist[i][0])
    temp.append(min(dp[i-1][0],dp[i-1][2])+rgblist[i][1])
    temp.append(min(dp[i-1][0],dp[i-1][1])+rgblist[i][2])

    dp.append(temp)

print(min(dp[N-1]))