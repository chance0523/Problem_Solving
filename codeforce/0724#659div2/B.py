import sys
input = sys.stdin.readline

tc = int(input())


for _ in range(tc):
    n, k, l = map(int, input().split())
    dList = list(map(int, input().split()))
    flag = True  # increse
