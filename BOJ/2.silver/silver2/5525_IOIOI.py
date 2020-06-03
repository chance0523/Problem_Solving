# 5525번. IOIOI


import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
s = input().rstrip()

i = -1
cntO = 0
ans = 0
try:
    while i < m-2:
        i += 1
        if s[i] == 'I':
            cntO = 0
            while s[i+1] == 'O' and s[i+2] == 'I':
                cntO += 1
                i += 2
                if cntO == n:
                    cntO -= 1
                    ans += 1
                if i > m-2:
                    break
except:
    pass
print(ans)
