# 1744번. 수 묶기


n = int(input())
over = []
zero = []
under = []
ans = 0

for _ in range(n):
    num = int(input())
    if num > 0:  # 양수
        over.append(num)
    elif num == 0:
        zero.append(num)
    else:  # 음수
        under.append(num)

# 일단 정렬
over.sort(reverse=True)
under.sort()

# 양수부터
# 큰수부터 2개씩 묶는다
# 홀수개면 하나가 남으니 먼저 더해줌
if len(over) % 2 != 0:
    ans += over[-1]
for i in range(1, len(over), 2):  # 이렇게 해줘야 -1 index 접근 안 함
    # 1은 더하는게 곱하는 것보다 크다
    if over[i] == 1:  # len(over)가 홀수이면 over[-1]이 1일것이니 신경 안 써도 된다.
        ans += (over[i-1] + over[i])
    else:
        ans += (over[i-1] * over[i])

# 음수
# 작은 수부터 2개씩 묶는다.
# 홀수개면 남은 하나는 더해주기
if len(under) % 2 != 0:
    # 0이 나왔다면 곱해준다.
    if zero:
        ans += 0 * under[-1]  # 0이 된다.
    else:
        ans += under[-1]
for i in range(1, len(under), 2):  # 양수와 같은 방식
    # 음수끼리는 무조건 곱해야 커진다
    ans += (under[i - 1] * under[i])

print(ans)
