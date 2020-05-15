# 16962번. DFS 스페셜 저지

import sys
input = sys.stdin.readline


def dfs(graph, gList):
    # 시작노드가 1이 아니면 0 return
    if gList[0] != 1:
        return 0
    stack = [1]
    visited = []
    cnt = 0
    next = []
    while stack:
        # n을 꺼내고 next에 n과 이어져 있고
        # 아직 방문 하지 않은 지점을 넣는다.
        print('\nstakcB', stack)
        n = stack.pop()
        for value in graph[n]:
            if value not in visited:
                next.append(value)
        print('n=', n)
        print('gList[cnt]', gList[cnt])
        print('next=', next)
        print('stackA=', stack)
        if n not in visited:
            # n이 이번에 방문해야하는 곳이 아닐 때
            if gList[cnt] != n:
                if len(stack) == 0:
                    return 0
                else:
                    # 다음에 방문해야하는 곳이 next에 없을 때
                    if stack[-1] not in next:
                        return 0
                stack.insert(0, n)
                continue
            else:
                visited.append(n)
                print(next)
                stack.extend(next)
                next = []
                cnt += 1
    return 1


def makeLevel(graph, n):
    level = {}
    visited = []
    for i in range(1, n+1):
        level[i] = []
    level[1].append(1)
    visited.append(1)
    # for value in level[1]:
    #     level[2].append(value)
    # print(level)
    lv = 1
    while True:
        if len(visited) == n:
            break
        for value in level[lv]:
            for num in graph[value]:
                if num not in visited:
                    visited.append(num)
                    level[lv+1].append(num)
        lv += 1

    return level


def dfs2(graph, gList, level):
    # gList=[1,2,3,4]
    flag = True
    visited = [1]
    if gList[1] not in visited:
        if gList[1] in graph[gList[0]]:
            flag = True
            visited.append(gList[1])


# graph 만들기
n = int(input())
graph = {}
for i in range(1, n+1):
    graph[i] = []
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[a].sort()
    graph[b].append(a)
    graph[b].sort()


gList = list(map(int, input().split()))  # 방문 순서 입력

level = makeLevel(graph, n)

print(dfs2(graph, gList, level))
