import sys
input = sys.stdin.readline


t = int(input())


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    print(*nList[::-1])

