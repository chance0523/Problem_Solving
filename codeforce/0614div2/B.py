from itertools import combinations
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    nList = list(map(int, input().split()))
    cnt=0
    ans=0
    for i in range(n):

