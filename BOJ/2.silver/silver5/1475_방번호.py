# 1475번. 방 번호


n = input()
numList = [0] * 10  # 0~9

for i in range(len(n)):
    num = int(n[i])
    numList[num] += 1

ans = (numList[6] + numList[9] + 1) // 2  # 6 9 쓸 때

for i in range(10):
    if i == 6 or i == 9:
        continue
    ans = max(ans, numList[i])

print(ans)
