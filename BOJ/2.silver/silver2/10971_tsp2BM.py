# 10971번. 외판원 순회2 - 비트마스크


import sys
input = sys.stdin.readline


def tsp(idx, path):
    if path == total:
        return table[idx][0] if table[idx][0] > 0 else 20202020
    if memo[idx][path] > 0:
        return memo[idx][path]

    tmp = 20202020
    for i in range(1, n):
        if (path >> i) % 2 == 1 or table[idx][i] == 0:
            continue
        tmp = min(tmp, table[idx][i] + tsp(i, path | (1 << i)))
    memo[idx][path] = tmp
    return tmp


n = int(input())
table = [list(map(int, input().split())) for _ in range(n)]
memo = [[0]*(1 << n) for _ in range(n)]
total = (1 << n)-1
print(tsp(0, 1))
