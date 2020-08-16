import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    nList = list(input())
    cntList = []
    cnt = 0
    for i in range(len(nList)):
        if(nList[i] == '1'):
            cnt += 1
        else:
            cntList.append(cnt)
            cnt = 0
    cntList.sort(reverse=True)
    alice = 0
    for i in range(len(cntList)):
        if(i % 2 == 0):
            alice += cntList[i]
    print(alice)
