# 10800번 컬러볼


import sys
input = sys.stdin.readline

'''
참조
https://mygumi.tistory.com/273
'''

n = int(input())
ball = [[0, 0, i] for i in range(n)]
ans = [0 for i in range(n)]
for i in range(n):
    ball[i][1], ball[i][0] = map(int, input().split())  # 크기가 먼저오게 담는다

ball.sort()
# 크기, 색상, 인덱스

colors = [0 for i in range(n+1)]
s = 0
j = 0
for i in range(n):
    while ball[j][0] < ball[i][0]:
        colors[ball[j][1]] += ball[j][0]
        s += ball[j][0]
        j += 1

    ans[ball[i][2]] = s - colors[ball[i][1]]

for i in range(n):
    print(ans[i])
