# 11053번. 가장 긴 증가하는 부분 수열


a = int(input())
aList = list(map(int, input().split()))

dp = [1 for i in range(a)]
for i in range(a):
    for j in range(i+1):
        if aList[j] < aList[i]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))
