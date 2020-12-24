# 10708번. 크리스마스 파티


n = int(input())
m = int(input())
mList = list(map(int, input().split()))
friends = [0 for _ in range(n)]

for i in range(m):
    target = mList[i]
    nList = list(map(int, input().split()))
    for j in range(n):
        if nList[j] == target:  # 타겟을 맞췄으면
            friends[j] += 1
        else:  # 못 맞췄으면
            friends[target-1] += 1  # 인덱스 맞춰주기 위해
for i in range(n):
    print(friends[i])
