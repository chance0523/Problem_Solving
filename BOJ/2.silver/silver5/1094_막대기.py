# 1094번. 막대기


x = int(input())
stick = [64]  # 처음엔 64cm짜리 하나만 들어있다.
while True:
    if sum(stick) == x:
        print(len(stick))
        break
    # 합이 x보다 크다면
    cur = stick.pop()
    stick.append(cur // 2)  # 반으로 나눠주기
    if sum(stick) < x:  # 길이가 작으면
        stick.append(cur // 2)  # 나머지 반도 포함
