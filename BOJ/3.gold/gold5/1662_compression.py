# 1662번. 압축


s = input()
stack = []
b = [0 for i in range(len(s))]

for i in range(len(s)):  # 전처리
    if s[i] == '(':
        stack.append(i)
    elif s[i] == ')':
        b[stack.pop()] = i


def recur(left, right):
    result = 0
    while left < right:
        if s[left].isdigit():  # 괄호 안 숫자
            result += 1
            left += 1
        else:
            result -= 1  # K를 빼줌
            result += int(s[left-1]) * recur(left+1, b[left])
            left = b[left] + 1
    return result


print(recur(0, len(s)))
