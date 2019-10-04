N = int(input())
ans = [0 for i in range(101)]

ans[1] = 9
ans[2] = 17
# 마지막 두 자리가 10일때는 101, 89일때는 898밖에 안 이어짐
ans[3] = (17-2)*2+2

for i in range(4, N+1):
    ans[i] = (ans[i-1]-2)*2+2

print(ans[N] % 1000000000)
