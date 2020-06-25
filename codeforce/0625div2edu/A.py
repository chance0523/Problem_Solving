import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    # 1번 가게 : 하나에 a달러
    # 2번 가게 : b개에 c 달러 (하나에 c/b달러)
    a, b, c = map(int, input().split())

    if a >= c:
        # 1개만 사도 2번 가게가 더 싸다
        output1 = -1
        output2 = b
    else:  # a<c
        if a == (c/b):
            output1 = 1
            output2 = -1
        elif a < (c/b):
            output1 = 1
            output2 = -1
        else:  # a>(c/b)
            output1 = 1
            output2 = b
    print(output1, output2)
