'''
안녕하세요.
제 코드를 봐주셔서 감사합니다.
부족한 점들은 양해 부탁드립니다.
'''

import sys
input = sys.stdin.readline

n = int(input())
nList = list(map(int,input().rstrip().split()))
s = input().rstrip()
aList = [0 for i in range(53)]
for i in range(n):
    aList[nList[i]] += 1

sList = [0 for i in range(53)]
for i in range(n):
    if s[i] == ' ':
        sList[0] += 1
    elif ord('A') <= ord(s[i]) <= ord('Z'):
        sList[ord(s[i]) - ord('A') + 1] += 1
    else:
        sList[ord(s[i]) - ord('a') + 27] += 1

flag = True
for i in range(len(sList)):
    if aList[i] != sList[i]:
        flag = False
        break

if flag:
    print('y')
else:
    print('n')