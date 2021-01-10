# 15947번. 아기 석환 뚜루루 뚜루


mList = ['baby', 'sukhwan', 'tururu', 'turu',
         'very', 'cute', 'tururu', 'turu',
         'in', 'bed', 'tururu', 'turu',
         'baby', 'sukhwan']  # 14개 단어

n = int(input())-1
ans = ''
num = n % 14
numList = [2, 3, 6, 7, 10, 11]
if num in numList:
    k = n // 14
    if k >= 3:  # ru가 5번이상 반복 (기본 한번)
        if mList[num] == 'tururu':
            ans = f'tu+ru*{k+2}'
        else:
            if k == 3:
                ans = mList[num] + 'ru' * k
            else:
                ans = f'tu+ru*{k+1}'
    else:
        ans = mList[num] + 'ru' * k
else:
    ans = mList[num]
print(ans)
