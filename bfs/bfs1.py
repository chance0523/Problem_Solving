N,M,V=map(int,input().split())
matrix=[[0]*(N+1) for _ in range(N+1)]

for _ in range(M):
    link=list(map(int,input().split()))
    matrix[link[0]][link[1]] = 1
    matrix[link[1]][link[0]] = 1

def bfs(start):
    queue=[start]
    foot_prints=[start]
    while queue:
        current_node=queue.pop(0)
        for search_node in range(len(matrix[current_node])):
            if matrix[current_node][search_node] and search_node not in foot_prints:
                foot_prints+=[search_node]
                queue+=[search_node]
    return foot_prints

def bfs2(graph, start):
    visited = []
    queue = [start]

    while queue:
        n = queue.pop(0)
        if n not in visited:
            visited.append(n)
            queue += graph[n] - set(visited)
    return visited

print(*bfs2(matrix,V))
print(*bfs(V))
print(matrix)
