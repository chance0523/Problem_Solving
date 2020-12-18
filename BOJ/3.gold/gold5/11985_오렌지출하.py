# 11985번. 오렌지 출하


n, m, k = map(int, input().split())
oList = [0]
dp = [0]
for i in range(1, n+1):
    oList.append(int(input()))
    dp.append(k * i)
