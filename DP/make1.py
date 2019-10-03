N = int(input())
count = [-1 for c in range(1000001)]
count[1] = 0
count[2] = 1
count[3] = 1

for i in range(4,N+1):
    if i%3==0:
        if count[i//3]>count[i-1]:
            count[i]=count[i-1]
        else:
            count[i]=count[i//3]
    elif i%2==0:
        if count[i//2] > count[i-1]:
            count[i] = count[i-1]
        else:
            count[i] = count[i//2]
    else:
        count[i]=count[i-1]
    count[i]+=1

print(count[N])
