chai = [0 for _ in range(10)]
for case in range(0,10):
    l=[0 for _ in range(10)]
    l[case] = int(input()) #length
    #h=[0 for _ in range(1000)] #height
    h=list(map(int,input().split()))

    for i in range(2,l[case]-2):
        if h[i]>h[i-1] and h[i]>h[i-2] and h[i]>h[i+1] and h[i]>h[i+2]:
            chai[case]+=min(h[i]-h[i-1],h[i]-h[i-2],h[i]-h[i+1],h[i]-h[i+2])

for case in range(10):
    print('#%d %d'%(case+1,chai[case]))
