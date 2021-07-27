# 1647번. 도시 분할 계획

# 마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다.
# -> MST를 쓰고 제일 비싼 비용의 선을 지우면 두개로 분리되면서 최소값이 나온다!
import sys

input = sys.stdin.readline


def make(parent):
    for i in range(v + 1):
        parent[i] = i
    return parent


def find(parent, a):
    if parent[a] == a:
        return a
    parent[a] = find(parent, parent[a])
    return parent[a]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a > b:
        parent[a] = b
        return True
    elif a < b:
        parent[b] = a
        return True
    return False


n, m = map(int, input().rstrip().split())
parent = [i for i in range(n + 1)]  # make
edges = []
cnt, ans = 0, 0
for _ in range(m):
    a, b, c = map(int, input().rstrip().split())
    edges.append([c, a, b])
edges.sort()

for edge in edges:
    if union(parent, edge[1], edge[2]):
        ans += edge[0]
        cnt += 1
        if cnt == n - 2:
            break

print(ans)
