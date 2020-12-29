# 1059번. 좋은구간


l = int(input())
sList = list(map(int, input().split()))
n = int(input())
sList.insert(0, 0)  # 0 ~ sList[0] 구간을 만들어줘야한다.
sList.sort()

if n in sList:  # 구간을 만들 수 없음
    print(0)
else:
    for i in range(l):
        if sList[i] < n < sList[i + 1]:  # 이 두 숫자 사이에 있다면
            # 구간 개수 계산
            # n보다 작거나 같은 수 x n보다 크거나 같은수 - 1
            ans = (n - sList[i]) * (sList[i + 1] - n) - 1
            print(ans)
            break
