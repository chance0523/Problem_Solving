# 2628번. 종이 자르기


import sys
input = sys.stdin.readline

r, c = map(int, input().split())
# 가로와 세로에 양끝을 포함하고 정렬
garo = [0, c]
sero = [0, r]
for i in range(int(input())):
    dir, num = map(int, input().split())
    if dir == 0:
        garo.append(num)
    else:
        sero.append(num)
garo.sort()
sero.sort()

# 사이사이의 거리를 구해준다.
g = []
s = []
for i in range(len(garo)-1):
    g.append(garo[i+1]-garo[i])
for i in range(len(sero)-1):
    s.append(sero[i+1]-sero[i])

# 나온 배열을 정렬한다.
g.sort()
s.sort()

# 가장 큰 값끼리 곱한다
print(g[-1]*s[-1])
