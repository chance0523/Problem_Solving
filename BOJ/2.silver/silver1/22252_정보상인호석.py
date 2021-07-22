# 22252번. 정보 상인 호석


import heapq
import sys

input = sys.stdin.readline

q = int(input().rstrip())
names = {}
ans = 0
for i in range(q):
    qList = list(input().rstrip().split())
    op = int(qList[0])
    name = qList[1]
    if op == 1:
        k = int(qList[2])
        cList = qList[3:]
        try:
            for c in cList:
                heapq.heappush(names[name], -int(c))
        except:
            names[name] = []
            for c in cList:
                heapq.heappush(names[name], -int(c))
    else:  # op == 2
        b = int(qList[2])
        try:
            if len(names[name]) <= b:
                ans += -sum(names[name])
                names[name] = []
            else:
                for i in range(b):
                    ans -= heapq.heappop(names[name])
        except:
            pass
print(ans)