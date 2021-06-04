# 1297번. TV 크기


d, h, w = map(int, input().split())
r = d / ((h**2 + w**2)**0.5)
print(int(h * r), int(w * r))
