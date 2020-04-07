n, m, v = map(int, input().split())
board = [[0] * (n+1) for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    board[a][b] = board[b][a] = 1

visited = [0]*(n+1)
visited[v] = 1
queue = [0]*(n+1)
queue[0] = v
front = 0
next_node = front

while queue[next_node] and next_node != n:
    cn = queue[next_node] # cn = current_node
    for i in range(1, n+1):
        if board[cn][i] and not visited[i]:
            visited[i] = 1
            front += 1
            queue[front] = i
    next_node += 1


i = 0
while queue[i] != 0:
    print(queue[i], end=' ')
    i += 1
