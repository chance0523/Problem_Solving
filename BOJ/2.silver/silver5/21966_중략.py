# 21966번. (중략)


n = int(input())
s = input().rstrip()
l = len(s)
if l<=25:
    print(s)
else:
    mid = s[11:-11]
    if (mid.count('.') == 1 and mid[-1] == '.') or (mid.count('.') == 0):
        print(s[:11] + '...' + s[-11:])
    else:
        print(s[:9] + '......' + s[-10:])