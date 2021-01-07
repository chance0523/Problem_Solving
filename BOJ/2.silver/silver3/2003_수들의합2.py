# 2003번. 수들의 합 2


n, m = map(int, input().split())
nList = list(map(int, input().split()))
ans = 0
l = 0
r = 1
s = nList[0]  # 초기값
# 투 포인터
while True:
    if r == n and s < m:  # s>m이면 왼쪽 뺄 수 있음. 그 외의 경우만
        break
    if s == m:  # 합이 m일경우
        ans += 1
        s -= nList[l]  # 왼쪽 한 칸 땡김
        l += 1
    elif s < m:  # 합이 m보다 작을 경우
        s += nList[r]  # 오른쪽 한 칸 땡김
        r += 1
    else:  # 합이 m보다 클 경우
        s -= nList[l]  # 왼쪽 하나 빼줌
        l += 1
print(ans)
