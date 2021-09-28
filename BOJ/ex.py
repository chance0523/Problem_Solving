for _ in range(int(input())):
    a, b = map(int,input().split())
    if a < b:
        a,b = b, a
    ans = a
    while True:
        if ans % a == 0 and ans % b == 0:
            print(ans)
            break
        ans += a