# 1764번. 듣보잡


import sys
input = sys.stdin.readline

n, m = map(int, input().split())
hear_see = [0 for i in range(n+m)]

for i in range(n+m):
    hear_see[i] = input().rstrip()

# 모두 넣어준 뒤에 sort
hear_see.sort()

answer = 0
job = []

# 앞뒤 비교해서 같으면 듣보잡
for i in range(len(hear_see)-1):
    if hear_see[i] == hear_see[i+1]:
        job.append(hear_see[i])
        answer += 1

print(answer)
for row in job:
    print(row)
