# 2075번. N번째 큰 수


import heapq
import sys
input = sys.stdin.readline

n = int(input())
h = []
for i in range(n):
    # 한 줄 씩 보면서 비교해야 메모리 초과가 안 남
    nList = list(map(int, input().split()))
    for p in range(n):
        if len(h) == n:
            # 제일 작은 것을 꺼내서
            mi = heapq.heappop(h)
            # 지금 수와 비교
            if mi < nList[p]:
                # 지금 수가 더 크면 넣어줌
                heapq.heappush(h, (nList[p]))
            else:
                # 아니면 다시 넣어줌
                heapq.heappush(h, mi)
        else:
            heapq.heappush(h, (nList[p]))

# 다 끝나면 제일 작은 수를 출력
print(heapq.heappop(h))
