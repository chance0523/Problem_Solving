# 2775번. 부녀회장이 될테야

t = int(input())

apart = [[0 for _ in range(14)] for _ in range(15)]
apart[0] = [i for i in range(1, 15)]
for a in range(1, 15):
    for b in range(14):
        apart[a][b] = sum(apart[a-1][:b+1])

for _ in range(t):
    k = int(input())
    n = int(input())
    print(apart[k][n-1])
