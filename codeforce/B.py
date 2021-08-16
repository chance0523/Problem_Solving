import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    s = list(input().rstrip())
    ans = ''
    if 'R' not in s and 'B' not in s:
        for i in range(n):
            if i%2==0:
                ans += 'R'
            else:
                ans += 'B'
        print(ans)
        continue
    cnt = 0
    temp = ''
    for i in range(n):
        if s[i] in ['R','B']:
            c = s[i]
            if c == 'R':
                for j in range(cnt):
                    if j%2 == 0:
                        temp += 'B'
                    else:
                        temp += 'R'
            else:
                for j in range(cnt):
                    if j%2==0:
                        temp += 'R'
                    else:
                        temp += 'B'
            cnt = 0
            ans += temp[::-1]
            ans += c
            temp = ''
        else:
            cnt += 1
    if cnt:
        if c == 'R':
            for j in range(cnt):
                if j%2==0:
                    ans += 'B'
                else:
                    ans += 'R'
        else:
             for j in range(cnt):
                if j%2==0:
                    ans += 'R'
                else:
                    ans += 'B'
    print(ans)

