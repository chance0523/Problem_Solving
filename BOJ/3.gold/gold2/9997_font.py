# 9997번. 폰트


n = int(input())
nList = [0 for i in range(n)]

mm = (1 << 26)-1
ans = 0
for i in range(n):
    s = list(input())
    for j in range(len(s)):
        s[j] = ord(s[j])-ord('a')
        temp = 1 << s[j]
        nList[i] |= temp


def func(cnt, cur):
    global ans
    if cnt == n:
        if mm == cur:
            ans += 1
        return

    func(cnt+1, cur | nList[cnt])
    func(cnt+1, cur)


func(0, 0)

print(ans)
