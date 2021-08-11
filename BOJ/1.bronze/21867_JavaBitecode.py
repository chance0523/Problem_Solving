# 21867번. Java Bitecode


n = int(input())
s = input()
ans = ''
for i in range(n):
    if s[i] in ['J','A','V']:
        continue
    else:
        ans += s[i]
if ans == '':
    ans = 'nojava'
print(ans)