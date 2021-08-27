# 22950번. 이진수 나눗셈


n = int(input())
s = list(input())[::-1]
k = int(input())

ans = 'YES'
cnt = 0
for i in range(k):
    try:
        if s[i] == '0':
            cnt += 1
        else:
            break
    except:
        break
if cnt == len(s):
    ans = 'YES'
elif cnt == k:
    ans = 'YES'
else:
    ans = 'NO'
print(ans)