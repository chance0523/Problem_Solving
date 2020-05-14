# 4153번. 직각삼각형

while True:
    nList = list(map(int, input().split()))
    nList.sort()
    if nList[0] == 0:
        break
    else:
        a = nList[0]**2
        b = nList[1]**2
        c = nList[2]**2
        if c == a+b:
            print('right')
        else:
            print('wrong')
