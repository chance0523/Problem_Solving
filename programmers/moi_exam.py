# 모의고사


def solution(answers):
    l = len(answers)
    s1 = [1, 2, 3, 4, 5]
    s2 = [2, 1, 2, 3, 2, 4, 2, 5]  # 8
    s3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]  # 10

    c1 = c2 = c3 = 0

    for i in range(len(answers)):
        if answers[i] == s1[i % 5]:
            c1 += 1
        if answers[i] == s2[i % 8]:
            c2 += 1
        if answers[i] == s3[i % 10]:
            c3 += 1

    c = [c1, c2, c3]
    M = max(c1, c2, c3)
    answer = []
    for i in range(3):
        if c[i] == M:
            answer.append(i+1)
    return answer
