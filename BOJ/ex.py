while True:
    n = int(input())
    if n == 0:
        break
    sList = []
    for _ in range(n):
        s = input().rstrip()
        sList.append([s.lower(), s])
    sList.sort()
    print(sList[0][1])