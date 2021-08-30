import sys
input = sys.stdin.readline

n = int(input())
ans = ''
while True:
    if n==1:
        ans += 'A'
        break
    if n%2==1:
        n-=1
        ans += 'A'
    else:
        n //= 2
        ans += 'B'
print(ans[::-1])