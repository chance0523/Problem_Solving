N=int(input())
P=list(map(int,input().split()))

if N==1:
    print(P[0])
else:
    P.sort()

    i_sum=0
    min_sum=0

    for i in range(N):
        min_sum+=(i_sum+P[i])
        i_sum+=P[i]
    
    print(min_sum)

