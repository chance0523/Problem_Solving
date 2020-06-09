# 1912번. 연속합


n = int(input())
nList = list(map(int, input().split()))

sum = [nList[0]]
for i in range(n-1):
    sum.append(max(sum[i]+nList[i+1], nList[i+1]))
print(max(sum))
