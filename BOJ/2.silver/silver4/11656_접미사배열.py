# 11656번. 접미사 배열


s = input()
sList = []
for i in range(len(s)):
    sList.append(s[i: len(s)])
sList.sort()
for k in sList:
    print(k)
