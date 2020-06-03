# 15654번. N과 M (5)


from itertools import permutations
import sys
input = sys.stdin.readline


n, m = map(int, input().split())
nList = list(map(int, input().split()))
# 순열로 만들어줌
pList = list(permutations(nList, m))
# 증가하는 순서로 출력하기 위함
pList.sort()

for p in pList:
    for i in range(m):
        # 같은 줄에 출력
        print(p[i], end=' ')
    print()

# 비슷한 문제 : https://www.acmicpc.net/problem/15650
