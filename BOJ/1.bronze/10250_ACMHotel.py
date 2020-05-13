# 10250번. ACM 호텔


def hotel(h, w, n):
    y = n % h
    x = (n // h)+1
    if y == 0:
        y = h
        x -= 1
    return y*100+x


t = int(input())
for _ in range(t):
    h, w, n = map(int, input().split())
    print(hotel(h, w, n))
