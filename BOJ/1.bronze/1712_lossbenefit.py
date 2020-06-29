# 1712번. 손익분기점


a, b, c = map(int, input().split())

if c <= b:
    ans = -1
else:
    ans = a//(c-b) + 1
print(ans)
