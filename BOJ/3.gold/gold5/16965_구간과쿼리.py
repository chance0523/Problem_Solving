# 16965번. 구간과 쿼리


from collections import deque
n = int(input())
guList = []  # 구간 리스트


def canGo(x1, y1, x2, y2):  # 이동이 가능한지
    if x2 < x1 < y2 or x2 < y1 < y2:
        return True
    else:
        return False


for q in range(n):
    op, op1, op2 = map(int, input().split())
    if op == 1:
        x, y = op1, op2
        guList.append([op1, op2])

    else:  # op == 2
        a, b = op1 - 1, op2 - 1  # 인덱스 맞추기 위해서
        # 매번 현재까지 나온 구간들을 탐색한다
        box = []
        for i in range(len(guList)):
            box.append([])  # 빈 리스트 만들어주기
            for j in range(len(guList)):
                if canGo(guList[i][0], guList[i][1], guList[j][0], guList[j][1]):
                    box[i].append(j)  # 여기로 이동 가능한 것

        # bfs
        v = [False for _ in range(len(guList))]  # 방문처리 리스트
        flag = False

        d = deque([a])
        v[a] = True

        while d:
            num = d.popleft()
            if num == b:  # b에 도착 할 수 있으면
                flag = True
                break
            for k in box[num]:
                if not v[k]:
                    d.append(k)
                    v[k] = True

        # 출력
        if flag:
            print(1)
        else:
            print(0)
