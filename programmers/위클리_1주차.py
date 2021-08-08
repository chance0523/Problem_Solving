# 위클리 챌린지 1주차 : 부족한 금액 계산하기
# https://programmers.co.kr/learn/courses/30/lessons/82612


def solution(price, money, count):
    answer = -1
    s = 0
    for i in range(1, count + 1):
        s += price * i
    answer = s - money
    if answer < 0:
        answer = 0
    return answer