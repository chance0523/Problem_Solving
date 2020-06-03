# 1389번. 케빈 베이컨의 6단계 법칙


import sys
input = sys.stdin.readline

n, m = map(int, input().split())
re = [[0]*(n+1) for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    re[a][b] = 1
    re[b][a] = 1

for p in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i == j:
                continue
            else:
                if re[i][p] and re[p][j]:
                    if re[i][j] == 0:
                        re[i][j] = re[i][p]+re[p][j]
                    else:
                        re[i][j] = min(re[i][j], re[i][p]+re[p][j])

ans = []
for i in re:
    ans.append(sum(i))

# 가장 작은 값을 찾는다
minn = min(ans[1:])
# 여러 개라면 index()를 통해서 제일 앞에 있는 인덱스를 반환
print(ans.index(minn))
