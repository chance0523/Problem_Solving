# 2145번. 숫자 놀이


def fun(nList):
    if len(nList) == 1:
        print(nList[0])
        return
    s = str(sum(nList))
    fun(list(map(int, s)))


while True:
    n = input()
    if n == '0':
        break
    nList = list(map(int,n))
    fun(nList)
