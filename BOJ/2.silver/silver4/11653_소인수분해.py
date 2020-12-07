# 11653번. 소인수분해


n = int(input())
ans = []

num = 2  # 2부터 시작
while n != 1:  # n이 1이면 종료
    if n % num == 0:  # 인수라면 리스트에 넣어주기
        ans.append(num)
        n //= num  # 나눠주기
    else:  # 인수가 아니라면 다음 수로
        num += 1

for a in ans:
    print(a)
