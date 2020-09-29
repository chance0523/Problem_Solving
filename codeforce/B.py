import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().rstrip().split()))

    left = 0
    right = n-1
    for i in range(n):
        if nList[i] < i:
            break
        left = i
    for i in range(n-1, -1, -1):
        if nList[i] < n-1-i:
            break
        right = i
    if left >= right:
        print('Yes')
    else:
        print('No')
