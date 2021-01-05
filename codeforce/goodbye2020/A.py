import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    nList = list(map(int, input().split()))
    ans = []
    for i in range(n-1):
        for j in range(i+1, n):
            ans.append(0.5 * (nList[j] - nList[i]))
    print(len(set(ans)))
