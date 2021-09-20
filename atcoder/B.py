import sys
input = sys.stdin.readline

sList =[]
for i in range(3):
    sList.append(input().rstrip())
t = input().rstrip()
ans = ''
for i in range(len(t)):
    if t[i] == '1':
        ans += sList[0]
    elif t[i] == '2':
        ans += sList[1]
    else:
        ans += sList[2]
print(ans)