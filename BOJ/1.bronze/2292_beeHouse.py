# 2292번. 벌집

# 1 : 1
# 2 ~ 7 : 6
# 8 ~ 19 : 12
# 20 ~ 37 : 18
# 6개씩 증가한다

n = int(input())
start = 1
p = 6
num = 1
if n == 1:
    print(1)
else:
    while True:
        start += p
        num += 1
        if n <= start:
            print(num)
            break
        p += 6
