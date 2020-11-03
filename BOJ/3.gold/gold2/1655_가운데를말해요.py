# 1655번. 가운데를 말해요


# https://www.crocus.co.kr/625
# 1. 최대 힙의 크기는 최소 힙의 크기와 같거나, 하나 더 크다.
# 2. 최대 힙의 최대 원소는 최소 힙의 최소 원소보다 작거나 같다.
# 이때 알고리즘에 맞지 않다면 최대 힙, 최소 힙의 가장 위의 값을 swap해준다.
# [결과] 이때 이 두가지 규칙을 유지해 준다면 항상 최대 힙 top값이 중간값이 된다.


import sys
import heapq
input = sys.stdin.readline

minh = []
maxh = []

for _ in range(int(input())):
    num = int(input())
    if not maxh:  # 맨 처음에 넣어주기
        heapq.heappush(maxh, (-num, num))
    elif len(maxh) == len(minh):  # 1번 조건
        heapq.heappush(maxh, (-num, num))
    else:
        heapq.heappush(minh, (num, num))

    if maxh and minh and maxh[0][1] > minh[0][1]:  # 2번 조건을 만족하지 않으면
        # swap
        m = heapq.heappop(minh)[1]
        M = heapq.heappop(maxh)[1]
        heapq.heappush(maxh, (-m, m))
        heapq.heappush(minh, (M, M))
    print(maxh[0][1])
