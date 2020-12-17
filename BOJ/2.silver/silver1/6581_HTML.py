# 6581번. HTML


import sys
input_ = sys.stdin.read()


check = 1
curL = 0
for word in input_.split():
    if word == '<br>':  # br 태그
        print()
        curL = 0  # 초기화
    elif word == '<hr>':  # hr 태그
        if curL:  # 새줄이 아니라면
            print()
        print('-'*80)
        curL = 0  # 초기화
    else:
        wordL = len(word)
        if not curL:  # 줄의 시작
            print(word, end='')
            curL += wordL
        else:
            if curL + wordL + 1 < 80:
                print(' ', end='')
                print(word, end='')
                curL += wordL + 1
            elif curL + wordL + 1 == 80:  # 이번 줄을 다 채웠을 때
                print(' ', end='')
                print(word, end='')
                print()  # 새줄
                curL = 0
            else:  # 새로운 줄 만들어야 할 때
                curL = 0
                print()
                print(word, end='')
                curL += wordL
