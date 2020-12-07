a, b, c = map(int, input().split())
d = max(b - a, c - b)  # 더 간격이 넓은 곳으로 들어가기
print(d-1)
