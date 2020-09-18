import sys
input = sys.stdin.readline


n, d = map(int, input().split())
nList = [0 for i in range(n)]
for i in range(n):
    nList[i] = list(map(int, input().split()))
nList.sort()

idx = []
maxhappy = nList[0][1]
s = maxhappy  # 합을 바꿀 변수
j = 0
# sliding
for i in range(1, n):
    s += nList[i][1]
    while nList[i][0]-nList[j][0] >= d:  # 앞에 있는 요소 제거
        s -= nList[j][1]
        j += 1
    maxhappy = max(maxhappy, s)  # 최대값 비교

print(maxhappy)
