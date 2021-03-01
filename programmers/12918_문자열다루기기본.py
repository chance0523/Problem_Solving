# 12918번. 문자열 다루기 기본
# https://programmers.co.kr/learn/courses/30/lessons/12918


def solution(s):
    answer = True
    if len(s) != 4 and len(s) != 6:
        return False

    num = [str(i) for i in range(11)]

    for i in s:
        if i not in num:
            return False

    return answer
