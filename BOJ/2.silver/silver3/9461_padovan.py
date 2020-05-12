T = int(input())
P = [0 for i in range(101)]
P[0:5] = [0, 1, 1, 1, 2, 2]
for i in range(6, 101):
    P[i] = P[i-1]+P[i-5]
for i in range(T):
    N = int(input())
    print(P[N])
