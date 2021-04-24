n, k = map(int, input().split())
num = k % 10
num2 = (2 * k) % 10
ans = []
for i in range(1, n + 1):
    if i % 10 == num or i % 10 == num2:
        continue
    ans.append(i)

print(len(ans))
print(*ans)
