# 23246번. Sprot Climbing Combined


import sys
input = sys.stdin.readline

n = int(input())
nList = []
for i in range(n):
    b,p,q,r = map(int,input().split())
    mulScore = p*q*r # 곱점수
    sumScore = p+q+r # 합점수
    nList.append([mulScore, sumScore, b]) # 이렇게 넣어주면 정렬만 해주면됨

nList.sort() # 정렬해준다

print(nList[0][2], nList[1][2], nList[2][2]) # 출력