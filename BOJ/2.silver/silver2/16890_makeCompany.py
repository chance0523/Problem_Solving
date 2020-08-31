# 16890번. 창업


import sys
input = sys.stdin.readline


k = list(input().rstrip())
c = list(input().rstrip())
n = len(k)
ans = ['?' for i in range(n)]

k.sort()
c.sort(reverse=True)


turn = True
af = 0  # ans의 앞
ae = n-1  # 지금 ans의 맨 뒤에 넣으면 들어가는 곳
kf = 0  # k의 앞
ke = (n+1)//2-1  # k의 뒤
cf = 0  # c의 앞
ce = n//2-1  # c의 뒤

for i in range(n):
    if turn:
        # koo
        if k[kf] < c[cf]:  # 그냥 넣을 수 있음
            ans[af] = k[kf]
            af += 1
            kf += 1
        else:  # 뒤에서 빼서 뒤에 넣는게 낫다
            ans[ae] = k[ke]
            ae -= 1  # 뒤에 넣을 것을 줄여줌
            ke -= 1
    else:
        # cube
        if k[kf] < c[cf]:  # 그냥 넣을 수 있음
            ans[af] = c[cf]
            af += 1
            cf += 1
        else:
            ans[ae] = c[ce]
            ae -= 1
            ce -= 1
    turn = not turn

print(''.join(ans))
