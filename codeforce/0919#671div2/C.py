import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n, k = map(int, input().split())
    s = list(input().rstrip())
    flag = True
    for i in range(n-k):
        if s[i] == '?' and s[i+k] == '?':
            continue
        elif s[i] == '?':
            s[i] = s[i+k]
        elif s[i+k] == '?':
            s[i+k] = s[i]
        elif s[i] == s[i+k]:
            continue
        else:
            flag = False

    for i in range(n-k-1, -1, -1):
        if s[i] == '?' and s[i+k] == '?':
            continue
        elif s[i] == '?':
            s[i] = s[i+k]
        elif s[i+k] == '?':
            s[i+k] = s[i]
        elif s[i] == s[i+k]:
            continue
        else:
            flag = False

    if not flag:
        print('NO')
        continue

    one = zero = 0
    for i in range(k):
        if s[i] == '0':
            zero += 1
        elif s[i] == '1':
            one += 1
    if one*2 > k or zero*2 > k:
        print('NO')
    else:
        print('YES')
