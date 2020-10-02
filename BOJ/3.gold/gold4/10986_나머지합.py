# 10986번. 나머지합


n, m = map(int, input().split())
nList = list(map(int, input().split()))

# prefix sum
su = 0
s = [0 for i in range(1001)]
s[0] = 1
for i in range(n):
    su += nList[i]  # 구간 합 구하고
    su %= m  # 나머지만 넣기
    s[su] += 1

# combinations
ans = 0
for i in range(m):
    # 나머지가 같은것끼리 빼면 결국 나머지가 0이 됨
    ans += s[i]*(s[i]-1)/2

print(int(ans))
