import sys
input = sys.stdin.readline

t = int(input())


def can(nList):  # 연산을 할 수 있으면 true, 없으면 false
    if n == 1:
        return False
    for i in range(len(nList)-1):
        if nList[i] > nList[i+1]:
            return True
    return False


def acc(nList):
    first_zero = 0
    # 최초의 1보다 앞에 있는 0 찾기
    # 001101 이면 맨 앞 00
    # 이거는 못 지운다.
    for i in nList:
        if i == 1:
            break
        else:
            first_zero += 1
    # 마지막 0 찾기
    # 1이 그 0 뒤에 있나 없나 확인
    # 그 1은 못 지운다.
    last_one = 0
    for i in nList[::-1]:
        if i == 0:
            break
        else:
            last_one += 1
    ans = first_zero*'0'+'0'+last_one*'1'
    return ans


for _ in range(t):
    n = int(input())
    nList = list(map(int, input().rstrip()))
    if can(nList):
        print(acc(nList))
    else:
        print("".join(map(str, nList)))
