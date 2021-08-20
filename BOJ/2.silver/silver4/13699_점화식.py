# 13699번. 점화식


n = int(input())
t = [1,1,2,5]
ans = 0
for i in range(4,n+1):
    k = 0
    for j in range(0,i):
        k += t[j]*t[i-j-1]
    t.append(k)
print(t[n])
#1