# 9290번. 틱택토 이기기


t = int(input())
for tc in range(t):
    box = [0 for i in range(3)]
    for i in range(3):
        box[i] = list(input())
    nam = input()
    flag = False
    # 가로줄
    for i in range(3):
        if flag:
            break
        same = 0
        blank = False
        r = 0
        c = 0
        for j in range(3):
            if box[i][j] == nam:
                same += 1
            elif box[i][j] == '-':
                blank = True
                r = i
                c = j
        if same == 2 and blank:  # 놓을 수 있음
            box[r][c] = nam  # 바꿔준다
            flag = True  # 출력을 위한
    # 세로줄
    for j in range(3):
        if flag:
            break
        same = 0
        blank = False
        r = 0
        c = 0
        for i in range(3):
            if box[i][j] == nam:
                same += 1
            elif box[i][j] == '-':
                blank = True
                r = i
                c = j
        if same == 2 and blank:  # 놓을 수 있음
            box[r][c] = nam  # 바꿔준다
            flag = True  # 출력을 위한

    # 대각선 1,5,9
    same = 0
    blank = False
    r = 0
    c = 0
    for i in range(3):
        if flag:
            break
        if box[i][i] == nam:
            same += 1
        elif box[i][i] == '-':
            blank = True
            r = i
            c = i
        if same == 2 and blank:
            box[r][c] = nam
            flag = True

    # 대각선 3,5,7
    same = 0
    blank = False
    r = 0
    c = 0
    for i in range(3):
        if flag:
            break
        if box[2-i][i] == nam:
            same += 1
        elif box[2-i][i] == '-':
            blank = True
            r = 2-i
            c = i
    if not flag and same == 2 and blank:
        box[r][c] = nam

    print(f"Case {tc+1}: ")
    for i in range(3):
        print("".join(box[i]))
