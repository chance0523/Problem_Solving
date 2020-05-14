# 11651번. 좌표 정렬하기 2

n = int(input())
nList = []
for i in range(n):
    x, y = map(int, input().split())
    # x,y를 반대로 넣어서 정렬하고 반대로 빼는 것이 중요
    nList.append((y, x))
nList.sort()
for y, x in nList:
    print(x, y)
