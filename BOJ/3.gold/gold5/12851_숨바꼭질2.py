# 12851번. 숨바꼭질 2


from collections import deque
n, k = map(int, input().split())

q = deque([[n, 0]])

visited = [False for i in range(100001)]
ans = [1e9, 0]
t = 0
while q:
    t = q[0][1]  # 현재 걸린 시간
    if t > ans[0]:  # 이 이상은 볼 필요 없다
        break
    cur = q[0][0]  # 현재 위치
    visited[cur] = True  # 방문처리

    if cur == k:  # 수빈이와 만났을 때
        if t < ans[0]:  # 최소 시간이 변하는 경우
            ans[0] = t
            ans[1] = 1
        elif t == ans[0]:  # 이전 최소 시간과 동일 할 경우
            ans[1] += 1  # 방법의 수 ++

    if cur != 100000 and not visited[cur + 1]:  # x+1
        q.append([cur+1, t+1])
    if cur != 0 and not visited[cur - 1]:  # x-1
        q.append([cur-1, t+1])
    if cur <= 50000 and not visited[cur * 2]:  # x*2
        q.append([cur * 2, t + 1])

    q.popleft()

print(ans[0])
print(ans[1])
