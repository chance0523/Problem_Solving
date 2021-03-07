# 12932. 자연수 뒤집어 배열로 만들기
# https://programmers.co.kr/learn/courses/30/lessons/12932


def solution(n):
    nList = list(str(n))

    answer = []
    for i in range(len(nList)):
        answer.append(int(nList[i]))

    answer = answer[::-1]
    return answer
