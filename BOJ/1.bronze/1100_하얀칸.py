# 1100번. 하얀 칸


nList = []
for i in range(8):
    nList.append(list(input().rstrip()))
ans = 0
for i in range(8):
    for j in range(8):
        if (i+j)%2==0 and nList[i][j]=='F':
            ans+=1
print(ans)