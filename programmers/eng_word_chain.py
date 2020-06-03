# 영어 끝말잇기


def solution(n, words):
    answer = []
    wordDict = {}
    cnt = 0
    ll = len(words)
    for i in range(ll):
        if i >= 1 and words[i][0] != words[i-1][-1]:  # 끝말잇기가 안될때
            answer.append([(i % n)+1, (i//n)+1])
            return answer[0]
        else:  # 끝말잇기가 될 때
            if words[i] not in wordDict:
                wordDict[words[i]] = [(i % n)+1, (i//n)+1]
            elif words[i] in wordDict:  # 이미 말 한 단어 (딱 걸렸다!)
                answer.append([(i % n)+1, (i//n)+1])
                return answer[0]
    # 아무 이상 없을 때
    answer.append([0, 0])
    return answer[0]
