# 1986번. 체스


'''
주의 : 정말 bruteforce한 방법으로 구현하여
코드가 매우 김
'''
n, m = map(int, input().split())
box = [[0 for i in range(m)] for i in range(n)]
qList = list(map(int, input().split()))
kList = list(map(int, input().split()))
pList = list(map(int, input().split()))

q = qList[0]
k = kList[0]
p = pList[0]
if q:
    for i in range(q):
        box[qList[1+i*2]-1][qList[1+i*2+1]-1] = 'q'
if k:
    for i in range(k):
        box[kList[1+i*2]-1][kList[1+i*2+1]-1] = 'k'
if p:
    for i in range(p):
        box[pList[1+i*2]-1][pList[1+i*2+1]-1] = 'p'

# 나이트
if k:
    for i in range(k):
        y = kList[1+i*2]-1
        x = kList[1+i*2+1]-1
        # 8칸 처리
        # 위쪽
        if y-1 >= 0 and x-2 >= 0:
            if box[y-1][x-2] == 0:
                box[y-1][x-2] = 'u'
        if y-1 >= 0 and x+2 < m:
            if box[y-1][x+2] == 0:
                box[y-1][x+2] = 'u'
        if y-2 >= 0 and x-1 >= 0:
            if box[y-2][x-1] == 0:
                box[y-2][x-1] = 'u'
        if y-2 >= 0 and x+1 < m:
            if box[y-2][x+1] == 0:
                box[y-2][x+1] = 'u'
        # 아래쪽
        if y+1 < n and x-2 >= 0:
            if box[y+1][x-2] == 0:
                box[y+1][x-2] = 'u'
        if y+1 < n and x+2 < m:
            if box[y+1][x+2] == 0:
                box[y+1][x+2] = 'u'
        if y+2 < n and x-1 >= 0:
            if box[y+2][x-1] == 0:
                box[y+2][x-1] = 'u'
        if y+2 < n and x+1 < m:
            if box[y+2][x+1] == 0:
                box[y+2][x+1] = 'u'

# 퀸
if q:
    passList = ['q', 'k', 'p']
    changeList = [0, 'u']
    for i in range(q):
        y = qList[1+i*2]-1
        x = qList[1+i*2+1]-1
        # 왼쪽 가로줄
        l = 1
        while True:
            if x-l >= 0:
                if box[y][x-l] in changeList:
                    box[y][x-l] = 'u'
                    l += 1
                elif box[y][x-l] in passList:
                    break
            else:
                break
        # 오른쪽 가로줄
        r = 1
        while True:
            if x+r < m:
                if box[y][x+r] in changeList:
                    box[y][x+r] = 'u'
                    r += 1
                elif box[y][x+r] in passList:
                    break
            else:
                break
        # 위 세로줄
        u = 1
        while True:
            if y-u >= 0:
                if box[y-u][x] in changeList:
                    box[y-u][x] = 'u'
                    u += 1
                elif box[y-u][x] in passList:
                    break
            else:
                break
        # 아래 세로줄
        d = 1
        while True:
            if y+d < n:
                if box[y+d][x] in changeList:
                    box[y+d][x] = 'u'
                    d += 1
                elif box[y+d][x] in passList:
                    break
            else:
                break
        # 대각선 왼쪽 위
        di = 1
        while True:
            if y-di >= 0 and x-di >= 0:
                if box[y-di][x-di] in changeList:
                    box[y-di][x-di] = 'u'
                    di += 1
                elif box[y-di][x-di] in passList:
                    break
            else:
                break
        # 대각선 오른쪽 아래
        di = 1
        while True:
            if y+di < n and x+di < m:
                if box[y+di][x+di] in changeList:
                    box[y+di][x+di] = 'u'
                    di += 1
                elif box[y+di][x+di] in passList:
                    break
            else:
                break
        # 대각선 왼쪽 아래
        di = 1
        while True:
            if y+di < n and x-di >= 0:
                if box[y+di][x-di] in changeList:
                    box[y+di][x-di] = 'u'
                    di += 1
                elif box[y+di][x-di] in passList:
                    break
            else:
                break
        # 대각선 오른쪽 위
        di = 1
        while True:
            if y-di >= 0 and x+di < m:
                if box[y-di][x+di] in changeList:
                    box[y-di][x+di] = 'u'
                    di += 1
                elif box[y-di][x+di] in passList:
                    break
            else:
                break
ans = 0
for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            ans += 1
print(ans)
