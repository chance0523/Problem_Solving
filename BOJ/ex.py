x = int(input())
stick = [64]
ans = 0
while True:
    if sum(stick) == x:
        print(len(stick))
        break
    cur = stick.pop()
    stick.append(cur // 2)
    if sum(stick) < x:
        stick.append(cur // 2)
