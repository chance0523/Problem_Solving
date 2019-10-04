N = int(input())
ans = [1]*10
ans[0]=0
i=1
while i<N:
    next=[
        ans[1],
        ans[0]+ans[2],
        ans[1]+ans[3],
        ans[2]+ans[4],
        ans[3]+ans[5],
        ans[4]+ans[6],
        ans[5]+ans[7],
        ans[6]+ans[8],
        ans[7]+ans[9],
        ans[8]
    ]
    ans=next
    i+=1
print(sum(ans)%1000000000)