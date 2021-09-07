# 14405번. 피카츄


s = input().rstrip()
a = s.count('pi')*2
b = s.count('ka')*2
c = s.count('chu')*3
if a+b+c == len(s):
    print('YES')
else:
    print('NO')

