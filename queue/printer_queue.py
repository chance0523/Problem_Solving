from collections import deque
test_case = int(input())
for i in range(test_case):
    N, M = map(int, input().split())
    k = list(map(int, input().split()))
    find = k[M]
    q = []
    cnt=0
    while k:
        mm = max(k)
        if k[0] >= mm:
            q.append(k.pop(0))
            cnt+=1
            if q[len(q)-1]==find:
                print("fadfa"+"%d"%cnt)
        else:
            k.append(k.pop(0))
