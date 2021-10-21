'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

for _ in range(int(input())):
    nList = list(map(int,input().rstrip().split()))
    n = nList[0] # Ti
    nList = nList[1:] # Nij
    nDict = {}
    flag = False # 과반수 먹은 나라가 없다.

    for k in nList:
        try:
            nDict[k] += 1
            if nDict[k] > n//2: # 절반 초과
                ans = k
                flag = True
                break
        except:
            nDict[k] = 1
    if flag:
        print(ans)
    else:
        print('SYJKGW')

