# 1343번. 폴리오미노


import sys
sList = list(input().rstrip())
# 사전순으로 가장 앞서는 답 -> 가능하면 A로 채운다.
# 홀수개의 X -> 덮을 수 없다
ansList = []
cnt = 0
for i in range(len(sList)):
    if sList[i] == 'X':
        cnt += 1
    else: # '.'
        if cnt % 2 == 1: # 홀수개였으면
            print(-1)
            sys.exit()
        else:
            while True:
                if cnt >= 4:
                    cnt -= 4
                    ansList.append('AAAA')
                elif cnt == 2:
                    cnt -= 2
                    ansList.append('BB')
                else: # 0
                    break
        ansList.append('.')

if cnt > 0:
    if cnt % 2 == 1: # 홀수개였으면
        print(-1)
        sys.exit()
    else:
        while True:
            if cnt >= 4:
                cnt -= 4
                ansList.append('AAAA')
            elif cnt == 2:
                cnt -= 2
                ansList.append('BB')
            else: # 0
                break
print(''.join(ansList))