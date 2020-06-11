# 1026번. 보물


n = int(input())
aList = list(map(int, input().split()))
bList = list(map(int, input().split()))

# aList에서 큰 것들은 bList에서 작은 것들과
# 작은 것들은 큰 것들과 매칭
aList.sort(reverse=True)
bList.sort()

s = 0
for i in range(n):
    s += (aList[i]*bList[i])
print(s)
