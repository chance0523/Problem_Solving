k = int(input())
s = input()
ans = ''
for i in range(0, len(s), k):
    ans += s[i]
print(ans)