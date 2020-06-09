# 1427번. 소트인사이트


s = list(input())
s.sort(reverse=True)
for i in range(len(s)):
    print(s[i], end='')
