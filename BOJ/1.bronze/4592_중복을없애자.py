# 4592번. 중복을 없애자


while True:
    nList = list(map(int, input().split()))
    n = nList[0]
    if n == 0:
        break
    nList = nList[1:]
    ans = []
    for i in range(n-1):
        num = nList[i]
        if num != nList[i+1]:
            ans.append(num)
    ans.append(nList[-1])
    ans.append('$')
    print(*ans)
