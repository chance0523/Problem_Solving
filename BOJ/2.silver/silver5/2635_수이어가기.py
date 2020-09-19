# 2635번. 수 이어가기


import sys
n = int(input())
if n == 1:  # 1일때 예외 조심
    print(4)
    print("1 1 0 1")
    sys.exit()
ans = 0
ansList = []
for i in range(1, n):
    cnt = 1
    cntList = [n, i]  # 첫번째와 두번째 수는 넣어준다.
    while True:
        num = cntList[cnt-1] - cntList[cnt]  # 다음 수 구하기
        if num < 0:  # 음의 정수면
            if ans < cnt:  # 최대값 확인
                ans = cnt
                ansList = [cntList[i] for i in range(ans+1)]  # 값 넣기
            break
        cntList.append(num)
        cnt += 1

print(ans+1)
print(*ansList)
