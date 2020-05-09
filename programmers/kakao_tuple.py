def solution(s):
    answer = []

    sList = list(s.split('{'))
    sList2 = []
    for row in sList:
        if len(row) > 2:
            if row[-2] == '}':
                sList2.append(row[:-2])
            else:
                sList2.append(row[:-1])

    for i in range(len(sList2)):
        sList2[i] = list(map(int, sList2[i].split(',')))

    myLen = 1
    while myLen <= len(sList2):
        for row in sList2:
            if len(row) == myLen:
                for num in row:
                    if num in answer:
                        continue
                    else:
                        answer.append(num)
                        myLen += 1
    return answer
