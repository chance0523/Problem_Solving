import sys
input = sys.stdin.readline

t = int(input())

'''
'''

alpha = [chr(98+i) for i in range(25)]
alpha = alpha*300

for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    masterkey = 'abcdefghijklmnopqrstuvwxyz'*2
    sList = ['a'*50]
    for i in range(n):
        num = nList[i]
        sList.append(sList[i][:num]+alpha[i]+sList[i][num:])
    for s in sList:
        print(s[:200])
