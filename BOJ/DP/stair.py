stair=[]
n=int(input())

for i in range(n):
    stair.append(int(input()))

sum=[]
sum.append(stair[0])
sum.append(stair[1]+stair[0])
sum.append(max(stair[2]+stair[0],stair[2]+stair[1]))

for i in range(3,n):
    sum.append(max(stair[i]+sum[i-2],stair[i]+stair[i-1]+sum[i-3]))
print(sum[n-1])