# 2564번. 경비원


import sys
input = sys.stdin.readline

r, c = map(int, input().split())


def getDistanceFromZero(dir, d):
    if dir == 1:  # 북
        return d
    elif dir == 2:  # 남
        return r+c+r-d
    elif dir == 3:  # 서
        return r+c+r+c-d
    else:  # 동
        return r+d


def getDistance(loc, dong):
    total = r*2+c*2  # 둘레
    # 두가지 방면으로 구하기
    return min(abs(dong-loc), total-abs(dong-loc))


n = int(input())
nList = []
for i in range(n):
    dir, d = map(int, input().split())  # 방향, 거리
    nList.append(getDistanceFromZero(dir, d))  # 왼쪽 위 모서리로부터 거리

dir, d = map(int, input().split())
dong = getDistanceFromZero(dir, d)  # 동근이

ans = 0
for i in range(n):
    ans += getDistance(nList[i], dong)  # 최단경로 구해서 더해주기

print(ans)
