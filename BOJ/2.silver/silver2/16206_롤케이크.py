# 16206번. 롤케이크


def cut(a):
    global ans, m
    if m:
        a -= 10
        ans += 1
        m -= 1
        if a > 10:
            a = cut(a)
        elif a == 10:
            ans += 1
        return a
    else:
        return a
n,m = map(int,input().split())
nList = list(map(int,input().split()))
ans = 0
aList = []
aList2 = []
for i in range(n):
    if nList[i] >= 10:
        aList.append(nList[i])
aList.sort()

for i in range(len(aList)):
    if m <= 0:
        break
    elif aList[i] == 10:
        ans += 1
    elif aList[i] % 10 == 0:
        cut(aList[i])
    else:
        aList2.append(aList[i])

for i in range(len(aList2)):
    cut(aList2[i])

print(ans)