# 14225번. 부분수열의 합


from itertools import combinations

n = int(input())
nList = list(map(int, input().split()))
nList.sort()

cList = []
for i in range(1, n+1):  # bruteforce
    cList.extend(list(combinations(nList, i)))

v = [0 for i in range(sum(cList[-1])+2)]  # 범위. 합으로 안 나오면 +1된것이 답

for c in cList:
    v[sum(c)] += 1

for i in range(1, len(v)+1):  # 범위.
    if v[i] == 0:
        print(i)
        break
