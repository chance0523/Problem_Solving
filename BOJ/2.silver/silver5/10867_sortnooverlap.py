# 10867번. 중복 빼고 정렬하기


n = int(input())

nset = set(map(int, input().split()))
nList = list(nset)
nList.sort()
for i in nList:
    print(i, end=' ')
