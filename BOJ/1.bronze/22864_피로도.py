# 22864번. 피로도


a,b,c,m = map(int,input().split())

ans = 0
cur_a = 0
for t in range(24):
    if cur_a + a > m:
        if cur_a - c >= 0:
            cur_a -= c
    else:
        ans += b
        cur_a += a
print(ans)