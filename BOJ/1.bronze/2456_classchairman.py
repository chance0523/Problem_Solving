# 2456번. 나는 학급회장이다


import sys
input = sys.stdin.readline

# 점수, 3점개수, 2점개수, 1점개수, 후보자번호
can = [[0, 0, 0, 0, 1],
       [0, 0, 0, 0, 2],
       [0, 0, 0, 0, 3]]

for _ in range(int(input())):
    nList = list(map(int, input().split()))
    for i in range(3):
        can[i][0] += nList[i]
        can[i][4-nList[i]] += 1
# 점수 -> 3점 개수 -> ... 으로 정렬
can.sort(reverse=True)

# 유일할 때
if can[0][0] > can[1][0]:
    print(can[0][-1], can[0][0])
# 세사람 다 같은 점수
elif can[0][0] == can[1][0] and can[1][0] == can[2][0]:
    if can[0][1] > can[1][1]:
        print(can[0][-1], can[0][0])
    elif can[0][1] == can[1][1]:
        if can[0][2] > can[1][2]:
            print(can[0][-1], can[0][0])
        else:
            print(0, can[0][0])
# 두사람만 같은 점수
else:
    if can[0][1] > can[1][1]:
        print(can[0][-1], can[0][0])
    else:
        if can[0][2] > can[1][2]:
            print(can[0][-1], can[0][0])
        else:
            print(0, can[0][0])
