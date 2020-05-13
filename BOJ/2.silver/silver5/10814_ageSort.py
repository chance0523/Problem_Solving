# 10814번. 나이순 정렬

n = int(input())
userList = []
for i in range(n):
    age, name = input().split()
    # 몇 번째 들어왔는지도 확인
    userList.append((int(age), i, name))

userList.sort()

for age, i, name in userList:
    print(age, name)
