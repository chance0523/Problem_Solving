import sys
read=sys.stdin.readline

n=int(read())
arr1=[]
for i in range(n):
    a,b=map(int, read().split())
    arr1.append((b,a))

arr1.sort()

y_min,cnt=0,0
for b,a in arr1:
    if a>=y_min:
        y_min=b
        cnt+=1

print(cnt)