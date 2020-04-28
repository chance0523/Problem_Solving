# 5567. 결혼식

# 친구, 친구의 친구만 초대
n = int(input())  # 상근이의 동기의 수
m = int(input())  # 리스트의 길이

friendList = [[0]*(n+1) for _ in range(n+1)]

# 상근이는 1번
for i in range(m):
    x, y = map(int, input().split(' '))  # 1<=x<=y
    friendList[x][y] = 1

jiksok = friendList[1]  # 상근이의 직속 친구
ff = [0 for _ in range(n+1)]  # 상근이의 직속 친구의 친구

for x in range(2, n+1):
    for y in range(2, n+1):
        if friendList[x][y] == 1:
            if (friendList[1][x] == 1) ^ (friendList[1][y] == 1):  # 둘 다 모두 직속 친구인 경우 제외
                if friendList[1][x] == 1:  # x가 직속이면 y가 친구의 친구
                    ff[y] = 1
                else:
                    ff[x] = 1

print(sum(jiksok)+sum(ff))
