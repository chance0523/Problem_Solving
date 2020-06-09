# 11721번. 열 개씩 끊어 출력하기


st = input()

i = 0
while True:
    # 열개씩 출력
    print(st[0+i:10+i])
    # 다음 10개로 이동
    i += 10
    # 만약에 다음 10개가 단어의 길이를 넘어서면
    if len(st) < 10+i:
        # 그냥 나머지만 출력하고 break
        print(st[0+i:])
        break
