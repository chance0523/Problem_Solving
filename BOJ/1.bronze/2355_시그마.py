# 2355번. 시그마


a, b = map(int, input().split())
if a > b:
    a, b = b, a
toB = b * (b + 1) // 2
toA = a * (a + 1) // 2
ans = toB - toA + a
print(ans)
