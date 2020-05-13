# 1978번. 소수 찾기

n = int(input())
nList = list(map(int, input().split()))

m = 1000

# 소수 리스트 만들기
def p(m):
    pList = [True]*m

    k = int(m**0.5)
    for i in range(2, k):
        if pList[i]:
            for j in range(i+i, m, i):
                pList[j] = False
    return [i for i in range(2, m) if pList[i]]


answer = 0
pList = p(m)
for num in nList:
    if num in pList:
        answer += 1
print(answer)
