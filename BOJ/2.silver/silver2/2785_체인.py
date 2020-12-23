# 2785번. 체인


n = int(input())
nList = list(map(int, input().split()))
nList.sort()

ans = 0
while True:
    if len(nList) <= 1:  # 하나로 연결되었다면
        print(ans)
        break

    nList[0] -= 1  # 고리 하나 제거
    nList[-1] += nList.pop()
    ans += 1

    if nList[0] == 0:  # 다 제거했으면
        nList.pop(0)  # 이제 고려하지 않음
