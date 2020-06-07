# 1. 팰린드롬

s = input()


def isPal(ss):
    for i in range(len(ss)):
        if ss[i] != ss[-1-i]:
            return False
    return True


maxLen = 0

for i in range(len(s)):
    for j in range(i+1, len(s)+1):
        flag = isPal(s[i:j])
        if flag:
            if len(s[i:j]) > maxLen:
                maxLen = len(s[i:j])
print(maxLen)
