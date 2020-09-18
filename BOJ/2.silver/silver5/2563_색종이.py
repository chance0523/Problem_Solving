# 2563번. 색종이


fullmap = [[0 for i in range(101)] for i in range(101)]

for t in range(int(input())):
    c, r = map(int, input().split())
    # 크기는 10x10
    for i in range(r, r+10):
        for j in range(c, c+10):
            # 색종이가 도화지 밖으로 나가는 경우는 없다.
            fullmap[i][j] += 1

# 모든 색종이를 덮은 뒤 덮인 넓이 확인
ans = 0
for i in range(101):
    for j in range(101):
        if fullmap[i][j] >= 1:
            ans += 1
print(ans)
