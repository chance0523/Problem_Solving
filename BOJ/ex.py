nList = [i for i in range(5001)]
for i in range(len(nList)):
    num = list(str(i))
    if len(num) == len(set(num)):
        nList[i] = True
    else:
        nList[i] = False
while True:
    try:
        n,m = map(int, input().split())
        ans = 0
        for i in range(n, m+1):
            if nList[i]:
                ans += 1
        print(ans)
    except EOFError:
        break