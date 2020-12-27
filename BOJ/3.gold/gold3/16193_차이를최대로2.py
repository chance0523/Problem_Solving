# 16193번. 차이를 최대로 2


# 코드가 너무 더럽지만 로직만 파악하자...

n = int(input())
nList = list(map(int, input().split()))
nList.sort(reverse=True)
ans = 0
ansList = []
'''
맨 앞에는 중간수가 들어가야하고
그 다음부터
큰작큰작... vs 작큰작큰... 중 최대값을 구해준다.
'''


def initList(k):
    global ansList
    ansList = []
    ansList.append(k)


def func1():
    f = 0  # 앞
    b = n - 1  # 뒤
    for i in range(n - 1):
        if i % 2 == 0:
            # 작은 수 넣기 (뒤)
            ansList.append(nList[b])
            b -= 1
        else:
            # 큰 수 넣기 (앞)
            ansList.append(nList[f])
            f += 1
    getAns(ansList)


def func2():
    f = 0  # 앞
    b = n - 1  # 뒤
    for i in range(n - 1):
        if i % 2 == 1:
            # 작은 수 넣기 (뒤)
            ansList.append(nList[b])
            b -= 1
        else:
            # 큰 수 넣기 (앞)
            ansList.append(nList[f])
            f += 1
    getAns(ansList)


def getAns(ansList):
    global ans
    cnt = 0
    for i in range(n-1):
        cnt += abs(ansList[i] - ansList[i + 1])
    ans = max(ans, cnt)


if n % 2 == 0:
    initList(nList[n // 2 - 1])
    func1()  # 큰작큰작
    initList(nList[n // 2 - 1])
    func2()  # 작큰작큰
else:
    initList(nList[n // 2])
    func1()
    initList(nList[n // 2])
    func2()


print(ans)
