# 1629번. 곱셈


a, b, c = map(int, input().split())

# 이와 같은 일반적인 방법으로는 시간초과
# print(pow(a,b)%c)

# 이런 방법이 있다고 한다. 문제에서 설명한 그대로를 반환
print(pow(a, b, c))
