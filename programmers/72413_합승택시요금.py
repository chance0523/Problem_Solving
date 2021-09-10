def solution(n, s, a, b, fares):
    INF = 1e9
    box = [[INF for i in range(n+1)] for i in range(n+1)]
    
    for i in range(1, n+1):
        box[i][i] = 0
    for f in fares:
        box[f[0]][f[1]] = f[2]
        box[f[1]][f[0]] = f[2]
    
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(i, n+1):
                if i != j:
                    temp = min(box[i][j], box[i][k] + box[k][j])
                    box[i][j] = temp
                    box[j][i] = temp
    
    ans = INF
    for i in range(1, n+1):
        ans = min(ans, box[s][i] + box[i][a] + box[i][b])
    return ans