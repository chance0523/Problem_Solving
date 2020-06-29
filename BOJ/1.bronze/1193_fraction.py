# 1193번. 분수찾기


x = int(input())
# 짝수, 홀수 라인마다 순서가 다르다.

line = 1
while x > line:
    x -= line
    line += 1
# 이 연산 후의 x-1 만큼 더 가면 된다.
# line/1 또는 1/line에서 시작

if line % 2 == 0:
    # 1/line
    ja = x
    mo = line-(x-1)
else:
    # line/1
    ja = line-(x-1)
    mo = x
print(f'{ja}/{mo}')
