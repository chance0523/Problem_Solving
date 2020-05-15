# 10971번. 외판원 순회2


# pypy로 해야 시간 초과 안 난다...
from itertools import permutations
import sys
input = sys.stdin.readline
# 순열 사용

n = int(input())
graph = []
for i in range(n):
    graph.append([int(a) for a in input().split()])

perm = [i for i in range(n)]

answer = 1e9


def tsp(r):
    global graph, n
    cost = 0
    for i in range(len(r)-1):
        # 길이 있을 때
        if graph[r[i]][r[i+1]] != 0:
            # 비용을 더해줌
            cost += graph[r[i]][r[i+1]]
        else:
            # 길이 없음
            return -1
    # 시작 지점으로 돌아갈 때
    if graph[r[-1]][r[0]] == 0:
        # 길이 없음
        return -1
    else:
        cost += graph[r[-1]][r[0]]
    return cost


for c in permutations(perm):
    cost = tsp(c)
    if cost != -1:
        answer = min(answer, cost)
print(answer)
