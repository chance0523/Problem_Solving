'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

nList = list(map(int,input().rstrip().split()))
nList.sort()
if nList[0] == nList[1] or nList[1] == nList[2] or nList[0]+nList[1] == nList[2]:
    print('S')
else:
    print('N')