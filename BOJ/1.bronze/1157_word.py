# 1157번. 단어 공부

s = input()
s = s.lower()
ss = list(set(s))
ssList = []
for c in ss:
    ssList.append(s.count(c))

M = max(ssList)
if ssList.count(M) >= 2:
    print('?')
else:
    idx = ssList.index(M)
    print(ss[idx].upper())
