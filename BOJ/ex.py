'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline


n, k = map(int,input().split())
nList = [False for _ in range(n+1)]
cnt = 0
for i in range(2, n+1):
    for j in range(i, n+1, i):
        if nList[j]:
            pass
        else:
            nList[j] = True # 지워준다
            cnt += 1
            if cnt == k:
                print(j)
                sys.exit()