# 구명보트


def solution(people, limit):
    answer = 0
    people.sort()
    # i는 앞에서부터, j는 뒤에서부터
    i = 0
    j = len(people)-1
    while i <= j:
        answer += 1
        # 이 조합으로 태울 수 있으면 태우고 다음 조합
        if people[i]+people[j] <= limit:
            i += 1
            j -= 1
        # 태울 수 없으면 무거운 사람의 무게를 줄임
        else:
            j -= 1

    return answer
