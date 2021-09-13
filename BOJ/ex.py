while True:
    a, b = map(int,input().split())
    if a+b == 0:
        break
    # 두 수가 같은 경우는 없다.
    ans = [0,0]
    if b%a == 0:
        ans[0] = 1
    if a%b==0:
        ans[1] = 1
    if ans[0]:
        print('factor')
    elif ans[1]:
        print('multiple')
    else:
        print('neither')