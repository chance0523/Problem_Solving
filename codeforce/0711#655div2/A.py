import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    # 다 1일때도 성립한다.
    nList = [1 for i in range(n)]
    print(*nList)
