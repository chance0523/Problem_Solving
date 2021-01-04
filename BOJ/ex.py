import sys
input = sys.stdin.readline

n = int(input())
nList = sorted(list(map(int, input().split())))
print(*nList)
