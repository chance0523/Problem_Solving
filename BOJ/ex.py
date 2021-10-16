import sys
input = sys.stdin.readline

n = int(input())
k = 0
nList = []

for i in range(n):
    nList.append(input().rstrip()[::-1]) # 귀찮으니까 뒤집어서 넣어준다

for i in range(1, len(nList[0])+1): # 시간 충분.
    nSet = set()
    for j in range(n):
        nSet.add(nList[j][:i])
    if len(nSet) == n: # 중복되는게 없을때
        print(i)
        exit(0)