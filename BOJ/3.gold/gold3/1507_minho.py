# 1507번. 궁금한 민호
N = int(input())
s1 = []
s2 = [[1]*N for i in range(N)]
result = 0

for i in range(N):
    s1.append(list(map(int, input().split())))


def func(result):
    for k in range(N):
        for i in range(N):
            for j in range(N):
                if i == j or j == k or i == k:
                    continue
                if s1[i][j] == s1[i][k]+s1[k][j]:
                    s2[i][j] = 0
                elif s1[i][j] > s1[i][k]+s1[k][j]:
                    result = -1
    return result


result = func(result)


if result != -1:
    for i in range(N):
        for j in range(i, N):
            if s2[i][j]:
                result += s1[i][j]
print(result)
