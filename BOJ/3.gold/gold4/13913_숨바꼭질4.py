# 13913번. 숨바꼭질 4


from collections import deque


n, k = map(int, input().split())

q = deque([n])

d = dict()
v = dict()
d[n] = 0
v[n] = -1
ans = []

while q:
    l = q.popleft()
    if l in d:
        pass
    if l == k:  # 도착 했을 때
        break
    for loc in [l - 1, l + 1, l*2]:  # 이 위치로 갈 수 있음
        if loc not in d and 0 <= loc <= 100001:  # 처음 방문
            d[loc] = d[l] + 1
            v[loc] = l
            q.append(loc)

print(d[k])  # 걸린 시간

dv = v[k]
ans.append(k)
while dv != -1:
    ans.append(dv)
    dv = v[dv]
ans = ans[::-1]  # 거꾸로

print(*ans)  # 출력
