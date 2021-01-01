# 2170번. 선 긋기


import sys
input = sys.stdin.readline


n = int(input())
nList = []
for i in range(n):
    a, b = map(int, input().split())
    nList.append((a, b))

nList.sort()  # 시작점 기준으로 정렬

s = nList[0][0]  # 시작점
e = nList[0][1]  # 끝점

ans = e - s  # 초기값

for i in range(1, n):  # 두번째부터 탐색
    if nList[i][0] <= e and nList[i][1] <= e:  # 현재 구간이 이전 구간에 포함되면
        continue
    ans += nList[i][1] - nList[i][0]  # 일단 구간 더해주기
    # 1. 구간의 일부가 겹칠때
    if nList[i][0] < e:
        ans -= (e - nList[i][0])  # 겹친 부분을 빼줌

    s = nList[i][0]  # 시작점 업데이트
    e = nList[i][1]  # 끝점 업데이트


print(ans)
