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
    if k >= 3:
        if mList[num] == 'tururu':  # tururu
            ans = f'tu+ru*{k+2}'
        else:  # turu
            if k == 3:  # ru가 4번만 반복
                ans = mList[num] + 'ru' * k
            else:  # 5번 이상 반복
                ans = f'tu+ru*{k+1}'
    else:
        ans = mList[num] + 'ru' * k
else:
    ans = mList[num]
print(ans)
