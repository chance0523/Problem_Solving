N=int(input())
rope=[int(input()) for i in range(N)]

rope.sort(reverse=True)

weight=0

for i in range(N):
    if weight<rope[i]*(i+1):
        weight=rope[i]*(i+1)
print(weight)