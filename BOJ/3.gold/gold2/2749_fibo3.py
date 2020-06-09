# 2749번. 피보나치 수 3


n = int(input())
fibo = [0, 1]
mod = 1000000

# 피보나치 수를 나눈 수는 항상 주기를 가진다.
# 피보나치 수를 나눌 수를  k라고 할 때, k=10^n이면
# 주기는 15*10^(n-1)이다.

p = mod//10*15  # 피보나치 수를 나눈 수의 주기

for i in range(2, p):
    fibo.append(fibo[i-1]+fibo[i-2])
    fibo[i] %= mod

print(fibo[n % p])
