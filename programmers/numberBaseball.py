# 숫자 야구


def solution(baseball):
    answer = 0
    for i in range(123, 988):
        ii = str(i)
        flag = True
        if (ii[0] == ii[1] or ii[1] == ii[2] or ii[0] == ii[2]):
            continue
        if (ii[0] == '0' or ii[1] == '0' or ii[2] == '0'):
            continue

        for j in range(len(baseball)):
            strike = 0
            ball = 0
            num = str(baseball[j][0])
            for a in range(3):
                for b in range(3):
                    if a == b and ii[a] == num[b]:
                        strike += 1
                        continue
                    elif ii[a] == num[b]:
                        ball += 1
                        continue
            if baseball[j][1] != strike or baseball[j][2] != ball:
                flag = False
                break

        if flag:
            answer += 1

    return answer
