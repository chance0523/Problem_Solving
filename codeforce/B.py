import sys
input = sys.stdin.readline


for _ in range(int(input())):
    n = int(input())
    s = input().rstrip()
    ans = [[0 for i in range(n)] for i in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if i == j:
                ans[i][j] = 'X'
                continue
            if s[i] == '1' and s[j] == '1':
                ans[i][j] = '='
            elif s[i] == '1' and s[j] == '2':
                ans[i][j] = '='
            elif s[i] == '2' and s[j] == '1':
                ans[i][j] = '='
            else:
                cnt += 1
    if cnt > 0:
        if cnt%2 == 0:
            if cnt == 2:
                print('NO')
                continue
            else:
                first = n
                last = 0
                for i in range(n):
                    for j in range(n):
                        if s[i] == '2' and s[j] == '2':
                            if i < j:
                                first = min(first, i)
                                last = max(last, j)
                                ans[i][j] = '+'
                                ans[j][i] = '-'
                ans[first][last] = '-'
                ans[last][first] = '+'
        else:
            if cnt == 1:
                print('NO')
                continue
            else:
                first = n
                last = 0
                for i in range(n):
                    for j in range(n):
                        if s[i] == '2' and s[j] == '2':
                            if i < j:
                                first = min(first, i)
                                last = max(last, j)
                                ans[i][j] = '+'
                                ans[j][i] = '-'
                ans[first][last] = '-'
                ans[last][first] = '+'

    flag = True
    for i in range(n):
        if s[i] == '2' and '+' not in ans[i]:
            flag = False
            break
    if not flag:
        print('NO')
        continue
    print('YES')
    for i in range(n):
        print(''.join(ans[i]))


            