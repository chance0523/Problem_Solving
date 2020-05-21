# 2630번. 색종이 만들기


n = int(input())

p = [0 for i in range(n)]

for i in range(n):
    p[i] = list(map(int, input().split()))

w_cnt, b_cnt = 0, 0


def div(x, y, n):
    global w_cnt, b_cnt
    cnt = 0
    for i in range(x, x+n):
        for j in range(y, y+n):
            if p[i][j]:
                cnt += 1
    if not cnt:
        w_cnt += 1
    elif cnt == n**2:
        b_cnt += 1
    else:
        div(x, y, n//2)  # 왼쪽위
        div(x+n//2, y, n//2)  # 왼쪽아래
        div(x, y+n//2, n//2)  # 오른쪽위
        div(x+n//2, y+n//2, n//2)  # 오른쪽아래
    return


div(0, 0, n)
print(w_cnt)
print(b_cnt)
