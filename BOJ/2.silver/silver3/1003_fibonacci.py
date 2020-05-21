# 1003번. 피보나치 함수


t = int(input())

dp = [[1, 0], [0, 1]]

# dp[i][0]끼리 피보나치, dp[i][1]끼리 피보나치를 이룬다.

for i in range(2, 41):
    dp.append([dp[i-1][0]+dp[i-2][0], dp[i-1][1]+dp[i-2][1]])

for i in range(t):
    ii = int(input())
    print(dp[ii][0], dp[ii][1])
