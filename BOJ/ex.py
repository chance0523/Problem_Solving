'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

nDict = {} # 확장자-횟수 저장
nList = [] # 확장자를 저장
for _ in range(int(input())):
    s = input().rstrip().split('.')[1] # 확장자만 따온다
    if s not in nDict.keys(): # 처음 나왔다면
        nDict[s] = 1
        nList.append(s)
    else:
        nDict[s] += 1

nList.sort() # 사전순으로 정렬
for i in range(len(nList)):
    s = nList[i]
    print(s, nDict[s])
