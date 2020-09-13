# 1089번. 엘리베이터


init = ''
init += '###...#.###.###.#.#.###.###.###.###.###'
init += '#.#...#...#...#.#.#.#...#.....#.#.#.#.#'
init += '#.#...#.###.###.###.###.###...#.###.###'
init += '#.#...#.#.....#...#...#.#.#...#.#.#...#'
init += '###...#.###.###...#.###.###...#.###.###'
# print(len(init))

numbers = [[[] for i in range(5)] for i in range(10)]
# 0~9 숫자 모양 만들어주기
for i in range(5):  # 5줄
    for j in range(0, 39, 4):  # 3개씩
        numbers[j//4][i] = list(init[i*39+j:i*39+j+3])

# for i in range(5):
#     for j in range(3):
#         print(numbers[0][i][j], end='')
#     print()
n = int(input())

# n 개 숫자 담아줄 리스트
inNum = [[[] for i in range(5)] for i in range(n)]

for i in range(5):
    s = list(input().rstrip())  # 한줄 받고
    for j in range(0, n*3+(n-1), 4):  # 3칸씩 끊기. 범위 조심
        inNum[j//4][i] = list(s[j:j+3])

# 비교해주기 (numbers, inNum)
temp = [[] for i in range(n)]
for i in range(n):  # 하나씩 꺼내서
    for j in range(10):  # 10개 다 비교
        flag = True
        for p in range(5):  # 5줄
            if not flag:
                break
            for q in range(3):  # 3개
                if inNum[i][p][q] == '#' and numbers[j][p][q] == '.':
                    # 이건 매칭 할 수 없다.
                    flag = False
                    break
        if flag:  # 이건 매칭 할 수 있음
            temp[i].append(j)


# 모든 조합 만들기
c = [0 for i in range(n)]
for i in range(n):
    for j in range(len(temp[i])):
        c[i] += temp[i][j]

ans = 0
for i in range(n):
    ans *= 10
    ans += c[i]/len(temp[i])
print(ans)

'''
###
#.#
#.#
#.#
###
'''
