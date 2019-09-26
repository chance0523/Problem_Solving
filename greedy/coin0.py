N, K = map(int, input().split())
coin_val = [int(input()) for _ in range(N)]

coin_num = 0
coin_val.reverse()

for i in coin_val:
    if i <= K:
        coin_num += (K//i)
        K -= (K//i)*i
print(coin_num)
