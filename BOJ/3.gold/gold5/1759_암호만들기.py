# 1759번. 암호 만들기


from itertools import combinations
'''
4 6
a t c i s w
'''

l, c = map(int, input().split())
wList = list(input().split())
wList.sort()
cList = list(combinations(wList, l))

moList = ['a', 'e', 'i', 'o', 'u']

for c in cList:
    # 모음 개수
    mo = 0
    for m in moList:
        if m in c:
            mo += 1

    # 최소 한 개의 모음
    if mo == 0:
        continue
    # 최소 두 개의 자음
    if l - mo < 2:
        continue
    print(''.join(c))
