def getLCM(a, b):
    M = max(a, b)
    cnt = M
    while True:
        if not M % a and not M % b:
            return M
        M += cnt


for _ in range(int(input())):
    a, b = map(int, input().split())
    print(getLCM(a, b))
