import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    s = input().rstrip()
    a = False
    b = False
    l = 0
    r = 0
    if 'ab' in s:
        ans = s.index('ab')+1
        print(ans, ans+1)
    elif 'ba' in s:
        ans = s.index('ba')+1
        print(ans, ans+1)
    else:
        print(-1,-1)
        