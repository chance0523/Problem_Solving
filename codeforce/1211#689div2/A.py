import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n, k = map(int, input().split())
    ans = 'a' * k
    ans += 'cba' * 1000
    print(ans[:n])
