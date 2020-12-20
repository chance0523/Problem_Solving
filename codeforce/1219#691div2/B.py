import sys
input = sys.stdin.readline

n = int(input())
ans = [0 for i in range(1001)]
ans[1] = 4
ans[2] = 2 * 2
ans[3] = 12
ans[4] = 3 * 3
ans[5] = 3 * 4 + 4 * 3
ans[6] = 4 * 4
ans[7] = 4 * 5 + 5 * 4

for i in range(8, len(ans), 2):
    num = i//2+1
    ans[i] = num ** 2

for i in range(9, len(ans), 2):
    num = i//2+1
    ans[i] = num*(num+1) + (num+1)*num
print(ans[n])
# print(ans)
