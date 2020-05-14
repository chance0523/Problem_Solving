# 18111번. 마인크래프트

# pypy로 해야 시간 초과 안 남
import sys
input = sys.stdin.readline

n, m, b = map(int, input().split())
bList = [[0] for i in range(n)]

mintime = 1e9
maxblock = -1

for i in range(n):
    bList[i] = list(map(int, input().split()))

for i in range(min(map(min, bList)), max(map(max, bList))+1):
    time = 0
    block = b
    for x in range(n):
        for y in range(m):
            h = bList[x][y]-i
            if h > 0:  # 블록을 인벤토리에 넣을 때
                block += h
                time = time+h*2
            elif h < 0:  # 인벤토리에서 블록을 꺼낼 때
                block += h
                time = time-h
    if block >= 0:
        if mintime >= time:
            mintime = time
            maxblock = i

print(mintime, maxblock)
