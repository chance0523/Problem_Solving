# 2160번. 그림 비교


import sys
input = sys.stdin.readline

n = int(input())
picture = [[input().rstrip() for i in range(5)] for i in range(n)]
# print(picture)
ans = [35, 0, 0]
for i in range(n-1):
    for j in range(i+1, n):
        # 두 그림 비교
        cnt = 0
        for a in range(5):
            for b in range(7):
                if picture[i][a][b] != picture[j][a][b]:
                    cnt += 1
        if ans[0] > cnt:
            ans[0] = cnt
            ans[1] = i+1
            ans[2] = j+1
print(*ans[1:])
