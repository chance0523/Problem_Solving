# 2251번. 물통


from collections import deque

A, B, C = map(int, input().split())
vA = [False for i in range(201)]
vB = [False for i in range(201)]
vC = [False for i in range(201)]
v = [[[False for i in range(201)] for i in range(201)] for i in range(201)]

ans = [C]


def pour(a, b, c):
    if not v[a][b][c]:
        v[a][b][c] = True
        q.append([a, b, c])


q = deque([[0, 0, C]])  # 처음에는 C만 차있음
while q:
    cur = q.popleft()
    a = cur[0]
    b = cur[1]
    c = cur[2]

    if a == 0:
        ans.append(c)  # 이때 세번째 물통의 물의 양을 구해야
    # a->b
    if a >= B - b:  # 꽉 채울 수 있을 때
        pour(a-(B-b), B, c)
    else:  # a만큼 넣어야할때
        pour(0, b+a, c)
    # a->c
    if a >= C - c:
        pour(a - (C - c), b, C)
    else:
        pour(0, b, c+a)
    # b->a
    if b >= A - a:
        pour(A, b-(A-a), c)
    else:
        pour(a+b, 0, c)
    # b->c
    if b >= C - c:
        pour(a, b-(C-c), C)
    else:
        pour(a, 0, c+b)
    # c->a
    if c >= A - a:
        pour(A, b, c-(A-a))
    else:
        pour(a+c, b, 0)
    # c->b
    if c >= B - b:
        pour(a, B, c-(B-b))
    else:
        pour(a, b+c, 0)

ans = list(set(ans))  # 중복 제거해주고
ans.sort()  # 정렬
print(*ans)
