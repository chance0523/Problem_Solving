# K번째수
# https://programmers.co.kr/learn/courses/30/lessons/42748


def solution(array, commands):
    answer = []

    for p in range(len(commands)):
        temp = []
        for a in array:
            temp.append(a)
        i = commands[p][0]
        j = commands[p][1]
        k = commands[p][2]

        temp = temp[i-1:j]
        temp.sort()
        answer.append(temp[k-1])
    return answer
