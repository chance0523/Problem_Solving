# 10870번. 피보나치 수 5


n = int(input())

# n=0 일때를 따로 처리
if n == 0:
    print(0)
else:
    fibo = [0 for i in range(50)]
    fibo[0] = 0
    fibo[1] = 1

    for i in range(2, n+1):
        fibo[i] = fibo[i-1]+fibo[i-2]

    print(fibo[n])
