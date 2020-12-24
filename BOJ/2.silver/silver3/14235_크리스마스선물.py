# 14235번. 크리스마스 선물


import heapq
n = int(input())
present = []
for i in range(n):
    aList = list(map(int, input().split()))
    a = aList[0]
    if a == 0:  # 아이들에게 선물을 줘야함 (제일 큰 가치)
        if present:  # 줄 선물이 있으면
            print(heapq.heappop(present)[1])
        else:  # 줄 선물이 없으면
            print(-1)
    else:
        for j in range(1, a+1):  # 첫번째 숫자는 a
            heapq.heappush(present, (-aList[j], aList[j]))
