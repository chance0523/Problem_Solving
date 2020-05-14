# 1966번. 프린터 큐

import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    paper = list(map(int, input().split()))
    imp = [0 for i in range(n)]
    imp[m] = 1
    cnt = 0
    while True:
        if paper[0] == max(paper):
            cnt += 1
            if imp[0] == 1:
                print(cnt)
                break
            else:
                paper.pop(0)
                imp.pop(0)
        else:
            # 맨 뒤에 넣어줌
            paper.append(paper.pop(0))
            imp.append(imp.pop(0))
