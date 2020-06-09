# 11719번. 그대로 출력하기 2


# ide에서는 안되는데 제출하니까 된다...
while True:
    try:
        print(input())
    except EOFError:
        break
