'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

for _ in range(int(input())):
    nList = list(input().rstrip())
    ans = [0 for _ in range(8)]
    for i in range(38):
        temp = ''
        for j in range(3):
            temp += nList[i+j]
        if temp == 'TTT':
            ans[0] += 1
        elif temp == 'TTH':
            ans[1] += 1
        elif temp == 'THT':
            ans[2] += 1
        elif temp == 'THH':
            ans[3] += 1
        elif temp == 'HTT':
            ans[4] += 1
        elif temp == 'HTH':
            ans[5] += 1
        elif temp == 'HHT':
            ans[6] += 1
        elif temp == 'HHH':
            ans[7] += 1
    print(*ans)