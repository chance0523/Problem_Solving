# 10162번. 전자레인지


t = int(input())
a = 300
b = 60
c = 10
ans = [0, 0, 0]
ans[0] = t // a
t -= ans[0]*a
ans[1] = t // b
t -= ans[1]*b
ans[2] = t // c
t -= ans[2]*c
if t:
    print(-1)
else:
    print(*ans)
