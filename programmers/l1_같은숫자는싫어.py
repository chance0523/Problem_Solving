# level1. 같은 숫자는 싫어
# https://programmers.co.kr/learn/courses/30/lessons/12906?language=python3


def solution(arr):
    answer = []
    for i in range(len(arr)):
        if not answer:  # answer 리스트가 비어있으면
            answer.append(arr[i])  # 넣어준다.
        else:
            if answer[-1] != arr[i]:  # 지금 넣을 것이 answer의 맨 끝에 있지 않을 때
                answer.append(arr[i])
    return answer
