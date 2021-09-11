n = int(input())
nList = list(map(int,input().split()))
y = 0 
m = 0
for j in nList:
    y += (j // 30) * 10 + 10
    m += (j // 60) * 15 + 15
if y == m:
    print('Y','M',y)
elif y > m:
    print('M', m)
else:
    print('Y', y)