# 16198번. 에너지 모으기


def func(cur):
    global ans
    if len(wList) == 2:  # 처음과 마지막은 선택 할 수 없어서 2개만 남음
        ans = max(ans, cur)
        return
    for i in range(1, len(wList) - 1):  # 처음과 마지막은 선택 할 수 없다
        cur += (wList[i - 1] * wList[i + 1])  # 계산
        temp = wList[i]
        wList.pop(i)  # 제거해줌
        func(cur)  # 백트래킹
        wList.insert(i, temp)  # 다시 넣어줌
        cur -= (wList[i-1]*wList[i+1])  # 다시 빼줌


n = int(input())
wList = list(map(int, input().split()))
v = [False for _ in range(n)]
ans = 0

func(0)
print(ans)
