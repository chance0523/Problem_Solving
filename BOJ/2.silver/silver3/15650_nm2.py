# 16750번. N과 M(2)


from itertools import combinations
import sys
input = sys.stdin.readline

# n, m = 3, 1
# n, m = 4, 2
n, m = map(int, input().split())
nList = [i for i in range(1, n+1)]
# 조합 사용
cList = list(combinations(nList, m))

for c in cList:
    for i in range(m):
        # 요소를 한 줄에 출력
        print(c[i], end=' ')
    # 한 칸 띄어줌
    print()
