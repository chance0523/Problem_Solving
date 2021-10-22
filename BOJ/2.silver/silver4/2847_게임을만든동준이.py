# 2847번. 게임을 만든 동준이


n = int(input())
nList = [int(input()) for _ in range(n)]
nList = nList[::-1] # 인덱스 탐색하기 쉽게 뒤집어준다
M = nList[0] # 최대 난이도
ans = 0
for i in range(1, len(nList)):
    if M <= nList[i]: # 감소시켜야 하는 경우
        ans += nList[i] - (M - 1)
        M -= 1
    else: # 감소하지 않아도 되는 경우
        M = nList[i]
print(ans)
