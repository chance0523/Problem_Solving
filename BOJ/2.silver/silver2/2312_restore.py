# 2312번. 수 복원하기


for _ in range(int(input())):
    n = int(input())
    num = 2
    # 딕셔너리에 인수:개수 형태로 넣어줌
    ansDict = {}
    for i in range(n+1):
        ansDict[i] = 0

    while True:
        # 다 나누어지면 종료
        if n == 1:
            break
        # 나누어떨어지지 않으면 다음 수로
        if n % num != 0:
            num += 1
        else:
            # 인수 check
            n /= num
            ansDict[num] += 1

    for i in ansDict.items():
        if i[1] != 0:
            print(i[0], i[1])
