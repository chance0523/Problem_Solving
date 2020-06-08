# 1747번. 소수&팰린드롬

n = int(input())

# 소수 리스트를 만들어줌
# 소수면 False (0과 1도 False이므로 주의!!!)
primeList = [False for i in range(1003002)]

for i in range(2, len(primeList)):
    if not primeList[i]:
        for j in range(i+i, len(primeList), i):
            primeList[j] = True


# 팰린드롬수인지 판별
def isPalindrome(num):
    num = str(num)
    for i in range(len(num)):
        if num[i] != num[-1-i]:
            return False
    return True


# n보다 크거나 같은 범위에서 판별
for i in range(n, len(primeList)):
    # 소수 리스트에 1일 때 False로 저장 되어있어서
    # 이 때를 예외로 해줘야한다. 이것때문에 엄청 틀렸다.
    if n == 1:
        print(2)
        break

    # 소수이면 팰린드롬인지 판별
    if not primeList[i]:
        if isPalindrome(i):
            # 팰린드롬이면 바로 break를 해야 그게 가장 작은 수
            print(i)
            break
