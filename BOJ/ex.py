n = int(input())
s = []
for i in range(n):
    sL = list(input().split())
    s.append(sL)
    s[i][0],s[i][1] = s[i][1],s[i][0]
s.sort()
print(s[0][1])