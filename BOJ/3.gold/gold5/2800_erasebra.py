# 2800. 괄호제거


from itertools import combinations

init = input()

leftList = []
rightList = []
for i in range(len(init)):
    if init[i] == '(':
        leftList.append(i)
    elif init[i] == ')':  # 오른쪽 list만 쓴다.
        rightList.append([leftList.pop(), i])  # 쌍으로 저장


numbers = [i for i in range(len(rightList))]  # 이만큼의 쌍이 있다

cList = []  # 괄호가 10개까지라 조합 사용
for i in range(1, len(rightList)+1):  # 나중에 보니 굳이 sort 할 필요는 없다.
    cList.append(sorted(list(combinations(numbers, i)), reverse=True))

ans = []

for cc in cList:
    for c in cc:
        sel = [True for i in range(len(init))]  # true만 출력
        for i in range(len(c)):
            sel[rightList[c[i]][0]] = False
            sel[rightList[c[i]][1]] = False

        s = ''
        for i in range(len(init)):
            if sel[i]:
                s += init[i]
        ans.append(s)

ans = list(set(ans)) # 사전순으로 출력
ans.sort()
for a in ans:
    print(a)
