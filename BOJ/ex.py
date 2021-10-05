import sys
input = sys.stdin.readline

n = int(input())
nList = [int(input()) for i in range(n)]
nList.sort(reverse=True)
ans = 0
for i in range(n):
    money = nList[i] - i
    if money > 0:
        ans += money
print(ans)