import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    alpha = [0 for i in range(30)]
    flag = True
    for i in range(n):
        nList = list(input().rstrip())
        for j in range(len(nList)):
            alpha[ord(nList[j])-ord('a')] += 1

    for i in range(len(alpha)):
        if(alpha[i] > 0 and alpha[i] % n != 0):
            flag = False
            break
    if flag:
        print('YES')
    else:
        print('NO')
