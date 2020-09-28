s = input()
wList = list(s.split())  # 제목 만들기위함
sList = list(s)
l = len(sList)
n = int(input())  # 공백 개수
aList = list(map(int, input().split()))
title = ''
for i in range(len(wList)):
    t = wList[i][0]
    title += t.upper()

i = 0

# 내용
while True:
    if i == l:
        break
    if sList[i] == ' ':  # 공백일때
        if n == 0:  # 더 못 쓸때
            title = -1
            break
        else:
            while True:
                if i == l-1:
                    break
                if sList[i] != sList[i+1]:
                    break
                i += 1
        n -= 1
    else:  # 알파벳일때
        if sList[i].isupper():  # 대문자
            c = ord(sList[i])-ord('A')
        else:  # 소문자
            c = ord(sList[i])-ord('a')
        if aList[c] == 0:  # 더 못 쓸때
            title = -1
            break
        else:  # 누를 수 있을 때
            while True:
                if i == l-1:  # 끝까지 봤을 때
                    break
                if sList[i] != sList[i+1]:  # 다음 수 꾹 못 누를 때
                    break
                i += 1  # 그 외에는 계속 누르기
        aList[c] -= 1  # 누른거 체크
    i += 1
if title == -1:
    print(title)
else:
    # 제목
    i = 0
    while True:
        if i == len(title):
            break
        c = ord(title[i])-ord('A')
        if aList[c] == 0:  # 더 못 쓸때
            title = -1
            break
        else:  # 누를 수 있을 때
            while True:
                if i == len(title)-1:  # 끝까지 봤을 때
                    break
                if title[i] != title[i+1]:  # 다음 수 꾹 못 누를 때
                    break
                i += 1  # 그 외에는 계속 누르기
        aList[c] -= 1  # 누른거 체크
        i += 1
    print(title)
