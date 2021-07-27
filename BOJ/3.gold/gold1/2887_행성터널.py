# 2887번. 행성 터널


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


n = int(input())
planets = []
for i in range(n):
    x, y, z = map(int, input().split())
    planets.append([x, y, z, i]) # 인덱스 추가
    
parent = [i for i in range(n + 1)]
edges = []
for j in range(3):
    planets.sort(key=lambda x:x[j])
    before = planets[0][3]
    for i in range(1,n):
        cur = planets[i][3]
        edges.append([abs(planets[i][j]-planets[i-1][j]), before, cur])
        before = cur
edges.sort(key=lambda x:x[0])

cnt, ans = 0, 0
# U-F
for edge in edges:
    if union(parent, edge[1], edge[2]):
        ans += edge[0]
        cnt += 1
        if cnt == n - 1:
            break

print(ans)
