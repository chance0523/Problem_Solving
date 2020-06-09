# 2747번. 피보나치 수


fibo = [0 for i in range(50)]
fibo[0] = 0
fibo[1] = 1

n = int(input())
for i in range(2, n+1):
    fibo[i] = fibo[i-1]+fibo[i-2]

print(fibo[n])
