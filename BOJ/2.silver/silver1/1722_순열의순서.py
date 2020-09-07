# 1722번. 순열의 순서


from itertools import permutations

n = int(input())
line = list(map(int, input().split()))

fact = [0, 1]
for i in range(2, n+1):
    fact.append(fact[i-1]*i)


if line[0] == 1:
    k = line[1] - 1
    num = n - 1
    s = [i for i in range(1, n + 1)]
    ans = []
    for _ in range(n - 1):
        ans.append(s[k // fact[num]])
        del s[k // fact[num]]
        k %= fact[num]
        num -= 1
    ans.append(s[0])
    print(*ans)
else:
    ans = 0
    s = line[1:]
    num = n - 1
    for i in range(n):
        cnt = 0
        for j in range(i, n):
            if i == j:
                continue
            if s[i] > s[j]:
                cnt += 1
        for k in range(cnt):
            ans += fact[num]
        num -= 1
    print(ans + 1)
