import sys
input = sys.stdin.readline

t = int(input())
alpha = [chr(97+i) for i in range(20)]
for _ in range(t):
    n = int(input())
    a = input()
    b = input()
    flag = True
    for i in range(n):
        if a[i] > b[i]:
            flag = False
            break
    if flag == False:
        print(-1)
        continue
    else:
        for al in range(20):
            for i in range(n):  # A
                ss = ''
                if alpha[al] == a[i]:
                    for j in range(i, n):
                        if alpha[al] == a[j]:
                            ss += a[j]  # substring
                        else:
                            break
