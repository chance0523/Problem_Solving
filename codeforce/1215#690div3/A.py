import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int, input().split()))
    l = 0
    r = n-1
    while True:
        if l > r:
            print()
            break
        if l == r:
            print(nList[l])
            break
        else:
            print(nList[l], nList[r], end=' ')
        l += 1
        r -= 1
