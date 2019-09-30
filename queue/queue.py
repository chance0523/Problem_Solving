from sys import stdin
q = []
#N = int(input())
for i in range(int(stdin.readline())):
    m = stdin.readline().split()
    if m[0] == 'push':
        q.append(m[1])
    elif m[0] == 'pop':
        if q:
            print(q.pop(0))
        else:
            print(-1)
    elif m[0] == 'size':
        print(len(q))
    elif m[0] == 'empty':
        if q:
            print(0)
        else:
            print(1)
    elif m[0] == 'front':
        if q:
            print(q[0])
        else:
            print(-1)
    elif m[0] == 'back':
        if q:
            print(q[-1])
        else:
            print(-1)
