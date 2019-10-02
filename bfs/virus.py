n=int(input())
virus=int(input())
computer=[[] for i in range(n+1)]

for i in range(virus):
    a,b=map(int,input().split())
    if not a in computer[b]:
        computer[b].append(a)
    if not b in computer[a]:
        computer[a].append(b)

answer=[1]

def bfs(now):
    global answer
    for i in computer[now]:
        if not i in answer:
            answer.append(i)
            bfs(i)
bfs(1)
print(len(answer)-1)