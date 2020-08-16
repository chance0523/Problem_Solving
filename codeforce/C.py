import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().rstrip()))
    cnt = 0
    idx = 0
    box = [0 for i in range(n)]
    while(True):
        box[idx-1] = 0
        for i in range(idx, n):
            box[i] = nList[i]+box[i-1]
            if i-idx+1 == box[i]:
                cnt += 1
        idx += 1
        # print(box)
        if idx == n+1:
            print(cnt)
            break
