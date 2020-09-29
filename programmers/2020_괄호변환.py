def solution(p):
    # ( ) 개수 같으면 '균형' 잡힌 문자열
    # 짝도 모두 맞으면 '올바른' 문자열
    # input 균형잡힌 문자열 -> return 올바른 문자열
    answer = ''

    # 1단계
    if len(p) == 0:
        return p
    if isRight(p):
        return p

    u = p
    v = ''

    # 2단계
    for i in range(1, len(p), 2):
        u = p[:i+1]
        v = p[i+1:]
        if isBalanced(u) and isBalanced(v):  # 찾으면 바로 break
            break

    # 3단계
    if isRight(u):
        answer = u + solution(v)  # 재귀
        return answer
    # 4단계
    else:
        temp = '('  # 4-1
        temp += solution(v)  # 4-2
        temp += ')'  # 4-3
        u = change(u)  # 4-4
        answer = temp + u

    return answer


def isBalanced(s):
    left = 0  # (
    right = 0  # )
    for i in s:
        if i == '(':
            left += 1
        elif i == ')':
            right += 1
    if left == right:  # 균형잡힘
        return True
    else:
        return False


def isRight(s):
    # 이미 균형은 잡혀있음
    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        elif i == ')':
            if not stack:
                return False
            stack.pop()
    if stack:
        return False
    return True


def change(s):
    s = list(s[1:-1])  # 앞뒤제거
    if s == '':
        return s
    for i in range(len(s)):  # 괄호 방향 뒤집기
        if s[i] == '(':
            s[i] = ')'
        elif s[i] == ')':
            s[i] = '('
    return ''.join(s)
