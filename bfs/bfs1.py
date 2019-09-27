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
next_node=front

while queue[front] and front != n:
    nd = queue[front]
    for i in range(1, n+1):
        if board[nd][i] and not visited[i]:
            visited[i] = 1
            front+=1
            queue[front] = i
 #           print(queue)
    next_node+=1
    front=queue[next_node]

#print(board)
print(*queue[0:n])
#print(visited)
