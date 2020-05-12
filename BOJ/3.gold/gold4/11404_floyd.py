# 11404. 플로이드
n = int(input())  # 도시의 개수
m = int(input())  # 버스의 개수
graph = [[1e9]*(n+1) for _ in range(n+1)]


def init_graph():
    for i in range(m):
        a, b, c = map(int, input().split())
        if graph[a][b] > c:
            graph[a][b] = c
    for i in range(1, n+1):
        for j in range(1, m+1):
            if i == j:
                graph[i][j] = 0


def solve_graph():
    for i in range(1, n+1):  # 거쳐갈 노드
        for v in range(1, n+1):  # 시작 노드
            if i == v:
                continue
            for nv in range(1, n+1):  # 도착 노드
                if graph[v][nv] > graph[v][i]+graph[i][nv]:
                    graph[v][nv] = graph[v][i]+graph[i][nv]


init_graph()
solve_graph()
for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == 1e9:
            print("0", end=' ')
        else:
            print(graph[i][j], end=' ')
    print()
