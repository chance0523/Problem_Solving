import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    n *= 2
    ans = 0.5
    for i in range(1, n+1):
        ans*=i
        ans%=1000000007 
    print(int(ans))

