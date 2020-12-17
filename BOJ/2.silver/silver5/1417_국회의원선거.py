# 1417번. 국회의원 선거


n = int(input())
nList = [int(input()) for _ in range(n)]

da = nList[0]
nList.pop(0)
if n == 1:  # 런타임에러 방지
    print(0)
else:
    ans = 0
    while True:
        nList.sort()  # 계속 정렬해줌
        if da > nList[-1]:  # 다솜이의 값이 제일 클 때
            print(ans)
            break
        # 한 표를 넘겨받음
        nList[-1] -= 1
        da += 1
        ans += 1
