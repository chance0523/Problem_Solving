# 4299번. AFC 윔블던


h, c = map(int, input().split())
a = (h + c)
b = (h - c)
if a < 0 or b < 0 or a % 2 == 1 or b % 2 == 1:
    print(-1)
else:
    print(max(a, b) // 2, min(a, b) // 2)
